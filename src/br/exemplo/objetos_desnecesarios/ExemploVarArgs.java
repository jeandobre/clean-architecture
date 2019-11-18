package br.exemplo.objetos_desnecesarios;

public class ExemploVarArgs {

    // Uso simples dos varargs
    static int sum(int... args){
        int sum = 0;
        for(int arg : args)
            sum += arg;
        return sum;
    }

    //Maneira ERRADA de se usar varargs para passar um ou mais argumentos
    // o args[0] tem uma informaão, no restante tem outra representação
    static int min(int... args){
        if(args.length == 0)
            throw new IllegalArgumentException("Too few arguments");
        int min = args[0];
        for(int i = 1; i < args.length; i++)
            if(args[i] < min)
                min = args[i];
        return min;
    }

    // Maneira corrteta de usar varargs para passar um ou mais argumentos
    static int min(int firstArg, int... remainingArgs){
        int min = firstArg;
        for(int arg : remainingArgs)
            if(arg < min)
                min = arg;
        return min;
    }
}
