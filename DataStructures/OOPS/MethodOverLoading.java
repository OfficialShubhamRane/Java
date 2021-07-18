class MethodOverLoading {

    public void area(int l) {
        System.out.println("Square");
    }

    public void area(int l, int w) {
        System.out.println("Rectangle");
    }

    public static void main(String[] args) {
        MethodOverLoading obj = new MethodOverLoading();
        obj.area(10, 10);
    }

}