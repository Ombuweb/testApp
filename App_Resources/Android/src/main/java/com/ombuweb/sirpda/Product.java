package com.ombuweb.sirpda;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "products", foreignKeys = {@ForeignKey(entity = Inventory.class,parentColumns = {
        "inventory_id"},childColumns = {"inventory_id"},onUpdate = CASCADE, onDelete = CASCADE)})
public class Product {
    @NonNull

    public long inventory_id;

    @PrimaryKey
    @NonNull
    private String codigo_de_articulo;
    private  String lote;
    @NonNull
    private Integer unidades;
    @NonNull
    private  Double precio_de_coste;
    @NonNull
    private Integer unidades_anteriores;
    private  String codigo_de_incidencia;
    private  String observaciones;

public  Product(@NonNull Long inventory_id,@NonNull String codigo_de_articulo,String lote,
                @NonNull Integer unidades, @NonNull Double precio_de_coste,
                @NonNull Integer unidades_anteriores,
                String codigo_de_incidencia,
                String observaciones){
this.inventory_id = inventory_id;
    this.codigo_de_articulo = codigo_de_articulo;
    this.lote = lote;
    this.unidades = unidades;
    this.precio_de_coste = precio_de_coste;
    this.unidades_anteriores = unidades_anteriores;
    this.codigo_de_incidencia = codigo_de_incidencia;
    this.observaciones = observaciones;
}

    @NonNull
    public String getCodigo_de_articulo() {
        return codigo_de_articulo;
    }

    public String getLote() {
        return lote;
    }

    @NonNull
    public Integer getUnidades() {
        return unidades;
    }

    @NonNull
    public Double getPrecio_de_coste() {
        return precio_de_coste;
    }

    @NonNull
    public Integer getUnidades_anteriores() {
        return unidades_anteriores;
    }

    public String getCodigo_de_incidencia() {
        return codigo_de_incidencia;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
