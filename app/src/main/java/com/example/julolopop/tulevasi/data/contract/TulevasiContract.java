package com.example.julolopop.tulevasi.data.contract;

import android.provider.BaseColumns;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Julolopop on 24/02/2018.
 */

public class TulevasiContract {
    public static final String DATABASE = "DBUsuarios";
    public static final int VERSION = 3;


    public static  class  TickedsEntry implements BaseColumns{
        public static final String TABLE = "Ticked";
        public static final String IDCATEGORIA = "id_categoria";
        public static final String IDPRODUCTO = "id_Productos";
        public static final String CANTIDAD = "cantidad";
        public static final String PRECIO = "precio";
        public static final String PRECIOTOTAL = "PrecioTotal";
        public static final String NOMBRE = "nombre";
        public static final String IDMESA = "id_Mesa";
        public static final String IDTRABAJADOR = "id_Trabajador";
        public static final String FECHAINI = "fechaIni";
        public static final String ESTADO = "estado";


        public static final String[] ALLCOLUMNS = new String[]{_ID,IDCATEGORIA, IDPRODUCTO, CANTIDAD, PRECIO, PRECIOTOTAL, NOMBRE, IDMESA, IDTRABAJADOR, FECHAINI, ESTADO};

        public static final String CREATE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s INTEGER,%s INTEGER,%s INTEGER" +
                        ",%s FLOAT,%s FLOAT, %s TEXT,%s INTEGER,%s INTEGER,%s TEXT,%s INTEGER)"
                , TABLE, _ID,IDCATEGORIA, IDPRODUCTO, CANTIDAD, PRECIO, PRECIOTOTAL, NOMBRE, IDMESA, IDTRABAJADOR, FECHAINI, ESTADO);

        public static final String DROP = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String INSERT = String.format("INSERT INTO %s VALUES(%s,%s,%s,%s,'%s',%s,%s,%s,%s,%s,'%s')", TABLE,
                null,
                1,
                1,
                1,
                new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis())),
                1,
                1,//
                1,
                1,
                2,
                "Pedido 1") + String.format(",(%s,%s,%s,%s,'%s',%s,%s,%s,%s,%s,'%s')",
                null,
                1,
                1,
                1,
                new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis())),
                1,
                2,//
                1,
                1,
                2,
                "Pedido 2") + String.format(",(%s,%s,%s,%s,'%s',%s,%s,%s,%s,%s,'%s')",
                null,
                1,
                1,
                1,
                new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis())),
                1,
                3,//
                1,
                1,
                2,
                "Pedido 3") + String.format(",(%s,%s,%s,%s,'%s',%s,%s,%s,%s,%s,'%s')",
                null,
                1,
                1,
                1,
                new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis())),
                1,
                4,//
                1,
                1,
                2,
                "Pedido 4") + String.format(",(%s,%s,%s,%s,'%s',%s,%s,%s,%s,%s,'%s')",
                null,
                1,
                1,
                1,
                new SimpleDateFormat("MM/dd/yyyy").format(new Date(System.currentTimeMillis())),
                1,
                5,//
                1,
                1,
                2,
                "Pedido 5");
    }

    public static class MesaEntry implements BaseColumns {
        public static final String TABLE = "Mesa";
        public static final String IDZONA = "id_Zona";
        public static final String NOMBRE = "nombre";

        public static final String[] ALLCOLUMNS = new String[]{_ID,IDZONA,NOMBRE};

        public static final String CREATE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s INTEGER, nombre TEXT)", TABLE, _ID, IDZONA, NOMBRE);

        public static final String DROP = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String INSERT = String.format("INSERT INTO %s VALUES(%s,%s,'%s')", TABLE,
                null,
                1,
                "Mesa 1") + String.format(",(%s,%s,'%s')",
                null,
                1,
                "Mesa 2") + String.format(",(%s,%s,'%s')",
                null,
                1,
                "Mesa 3") + String.format(",(%s,%s,'%s')",
                null,
                1,
                "Mesa 4") + String.format(",(%s,%s,'%s')",
                null,
                2,
                "Mesa 5");


    }

    public static class ProductosEntry implements BaseColumns {
        public static final String TABLE = "Productos";
        public static final String IDCATEGORIA = "id_Categoria";
        public static final String IMG = "img";
        public static final String PRECIO = "precio";
        public static final String NOMBRE = "nombre";

        public static final String[] ALLCOLUMNS = new String[]{_ID, IDCATEGORIA, IMG,PRECIO,NOMBRE};

        public static final String CREATE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s INTEGER,%s TEXT,%s FLOAT,%s TEXT)"
                , TABLE,_ID, IDCATEGORIA, IMG,PRECIO,NOMBRE);

        public static final String DROP = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String INSERT = String.format("INSERT INTO %s VALUES(%s,%s,'%s',%s,'%s')", TABLE,
                null,
                1,
                null,
                1,
                "Producto 1") + String.format(",(%s,%s,'%s',%s,'%s')",
                null,
                1,
                null,
                1,
                "Producto 2") + String.format(",(%s,%s,'%s',%s,'%s')",
                null,
                1,
                null,
                1,
                "Producto 3") + String.format(",(%s,%s,'%s',%s,'%s')",
                null,
                1,
                null,
                1,
                "Producto 4") + String.format(",(%s,%s,'%s',%s,'%s')",
                null,
                1,
                null,
                1,
                "Producto 5");

    }

    public static class CatalogoEntry implements BaseColumns {
        public static final String TABLE = "Catalogo";
        public static final String NOMBRE = "nombre";

        public static final String[] ALLCOLUMNS = new String[]{_ID, NOMBRE};

        public static final String CREATE = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT)", TABLE, _ID, NOMBRE);

        public static final String DROP = String.format("DROP TABLE IF EXISTS %s", TABLE);

        public static final String INSERT = String.format("INSERT INTO %s VALUES(%s,'%s')", TABLE,
                null,
                "Catalogo 1") + String.format(",(%s,'%s')",
                null,
                "Catalogo 2") + String.format(",(%s,'%s')",
                null,
                "Catalogo 3") + String.format(",(%s,'%s')",
                null,
                "Catalogo 4") + String.format(",(%s,'%s')",
                null,
                "Catalogo 5");

    }





}
