package com.ombuweb.sirpda;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity(tableName = "inventarios")
public class Inventory {
    @PrimaryKey(autoGenerate = true)
public  int inventory_id;
    @TypeConverters(DateConverter.class)
    private Date fecha;
    private Long hora;
    private String almancen;
    private String descripcion;
    private String usuario;

    public  Inventory(@NonNull Date fecha, @NonNull Long hora, @NonNull String almancen, @NonNull String descripcion, @NonNull String usuario){
        this.fecha = fecha;
        this.hora = hora;
        this.almancen = almancen;
        this.descripcion = descripcion;
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public Long getHora() {
        return hora;
    }

    public String getAlmancen() {
        return almancen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUsuario() {
        return usuario;
    }
}
