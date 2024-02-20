package fr.ecole3il.rodez2023.perlin.exception;

public class MauvaiseValeurException extends IllegalArgumentException{
    private final Object object;
    public MauvaiseValeurException(Object object){
        super("Valeur incorrecte : " + object);
        this.object = object;
    }

    public Object getObject(){
        return object;
    }
}
