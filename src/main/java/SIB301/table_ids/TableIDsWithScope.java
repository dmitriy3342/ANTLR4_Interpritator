package SIB301.table_ids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dmitr on 05.12.2016.
 */
public class TableIDsWithScope<T> {

    //    final static String SCOPE_DEFAULT = "scope_default";
    final static String TABLE_ID = "table_id";
    Map<String, Object> map;
    Integer sizeTable;


    public TableIDsWithScope(Integer sizeTable) {
        this.map = new HashMap<>();
        this.map.put(TABLE_ID, new TableIDs(sizeTable));
        this.sizeTable = sizeTable;
    }

    //scope1::scope2::scope3::md3
    public void put(String name, T value) {

        String[] scopes = name.split("::");
        Map<String, Object> mapTmp = map;

        for (int i = 0; i < scopes.length - 1; i++) {

            if (mapTmp.containsKey(scopes[i])) {
                mapTmp = (Map<String, Object>) mapTmp.get(scopes[i]);
            } else {
                mapTmp.put(scopes[i], new HashMap<>());
                mapTmp = (Map<String, Object>) mapTmp.get(scopes[i]);
            }
        }

        TableIDs<T> tableIDs;

        if (mapTmp.containsKey(TABLE_ID)) {
            tableIDs = (TableIDs<T>) mapTmp.get(TABLE_ID);
        } else {
            tableIDs = new TableIDs(sizeTable);
            mapTmp.put(TABLE_ID, tableIDs);
        }

        tableIDs = (TableIDs<T>) mapTmp.get(TABLE_ID);
        tableIDs.put(scopes[scopes.length - 1], value);


    }


    public T get(String name) {
        String[] scopes = name.split("::");
        Map<String, Object> mapTmp = map;
        List<Map<String, Object>> listMap = new ArrayList<>();

        for (int i = 0; i < scopes.length - 1; i++) {
            listMap.add(mapTmp);
            if (mapTmp.containsKey(scopes[i])) {
                mapTmp = (Map<String, Object>) mapTmp.get(scopes[i]);
            } else
                return null;
        }

        TableIDs<T> tableIDs;
        T value = null;
        if (mapTmp.containsKey(TABLE_ID)) {
            tableIDs = (TableIDs<T>) mapTmp.get(TABLE_ID);
            value = tableIDs.get(scopes[scopes.length - 1]);
        }


        for (int i = listMap.size() - 1; i >= 0 && value == null; i--) {

            mapTmp = listMap.get(i);

            if (mapTmp.containsKey(TABLE_ID)) {
                tableIDs = (TableIDs<T>) mapTmp.get(TABLE_ID);
                value = tableIDs.get(scopes[scopes.length - 1]);
            }
        }


        return value;
    }

    public void remove(String name) {
        String[] scopes = name.split("::");
        Map<String, Object> mapTmp = map;

        for (int i = 0; i < scopes.length - 1; i++) {
            if (mapTmp.containsKey(scopes[i])) {
                mapTmp = (Map<String, Object>) mapTmp.get(scopes[i]);
            } else
                return;
        }

        TableIDs<T> tableIDs;

        if (mapTmp.containsKey(TABLE_ID)) {
            tableIDs = (TableIDs<T>) mapTmp.get(TABLE_ID);
        } else
            return;

        tableIDs = (TableIDs<T>) mapTmp.get(TABLE_ID);
        tableIDs.remove(scopes[scopes.length - 1]);
    }

}
