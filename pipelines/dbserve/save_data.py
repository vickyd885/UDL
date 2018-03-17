import pandas as pd
import psycopg2

conn = psycopg2.connect(dbname='ldd', user='ldd_user', host='localhost', password='pass', port=5432)

sql_df = pd.read_sql("select p.permission_id, p.street, p.post_code, p.prim_add_obj_name from app_ldd.ld_permissions as p WHERE p.permission_date >= '20150101' and p.permission_date <= '20160101'", con = conn)

sql_df.to_csv("ldd.csv", index=False)
