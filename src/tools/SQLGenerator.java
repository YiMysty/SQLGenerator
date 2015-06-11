package tools;

import java.lang.reflect.Field;

public class SQLGenerator {
	public static String getInsertQuery(Object o){
		String SQL = "";
		switch(o.getClass().getSimpleName()){
		case "dimZone":
			SQL = NormalGenerator(o);
			break;
			default:
				System.out.println(o.getClass().getSimpleName());
				System.out.println("No SQL generated!");
				break;
		}
		return SQL;
	}
	
	static String NormalGenerator(Object o){
		String tableName = o.getClass().getSimpleName();
		String SQL = "insert into "+tableName+"(";
		Field[] fs = o.getClass().getDeclaredFields();
		String Column = "";
		String Values = "";
		for(Field f:fs){
			f.setAccessible(true);
			try {
				if(f.get(o)==null)
					continue;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Column += ","+f.getName();
			switch(f.getType().getSimpleName()){
			case "String":
				try {
					Values += ",'"+f.get(o).toString()+"'";
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "int":
				try {
					Values+=","+f.getInt(o);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("Unknown type "+f.getType().getSimpleName());
				break;
			}
		}
		if(Column.length()>0){
			Column = Column.substring(1);
			Values = Values.substring(1);
			SQL = SQL + Column+") values("+Values+")";
			return SQL;
		}
		return "SQL generate Error!";
	}
}
