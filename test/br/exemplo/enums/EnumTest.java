package br.exemplo.enums;

import org.junit.Test;
import java.util.*;

public class EnumTest {

    @Test
    public void testarWeightTable(){
        double earthWeight = Double.parseDouble("185");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for(Planet p: Planet.values())
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
    }

    @Test
    public void testarEnumOperation(){
        double x = Double.parseDouble("2");
        double y = Double.parseDouble("4");
        for(Operation op: Operation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    @Test
    public void testarTextEnum(){
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));
    }


    //Usando uma EnumMap para associar dados com um enum
    @Test
    public void testarEnumMap(){
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for(Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());

       // for(Plant p : garden)
        //    plantsByLifeCycle.get(p.lifeCycle).add(p);

        System.out.println(plantsByLifeCycle);
    }

    //Usando uma stream e uma EnumMap para associar dados com um enum
    @Test
    public void testarEnumMapMelhorado(){
        Set<Plant> garden = new HashSet<>();
    //    System.out.println(Arrays.stream(garden)
      //  .collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet())));
    }

    @Test
    public void testarOprationInterface(){
        double x = Double.parseDouble("5");
        double y = Double.parseDouble("3");
        test(ExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & OperationInterface> void test(
            Class<T> opEnumType, double x, double y){
        for(OperationInterface   op: opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));

    }

    @Test
    public void testarOprationInterfaceComCollection(){
        double x = Double.parseDouble("4");
        double y = Double.parseDouble("2");
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static void test(Collection<? extends OperationInterface> opSet, double x, double y){
        for(OperationInterface op: opSet)
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

}
