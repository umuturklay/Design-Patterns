class Facade {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();

        String input = "I want to watch a movie with Cinema mod on Netflix...";
        ecosystem.Choose(input);
        System.out.println("Enjoy...");
    }
}

class TV{
    public void turnOn(){System.out.println("TV turned on...");}
}

class SoundBar{
    public void on(){System.out.println("The SoundBar is on now...");}

    public void changeMod(String mod){
        if(mod.equals("Cinema") || mod.equals("Tv Show"))
            System.out.println("The SoundBar mod changed to " + mod);
        else
            System.out.println("Wrong mod...");
    }
}

class StreamingDevice{
    public void startDevice(){System.out.println("Device is ready to stream...");}

    public void chooseApp(String app){
        if(app.equals("Netflix") || app.equals("Exxen") || app.equals("Amazon Prime"))
            System.out.println("Streaming from " + app);
        else
            System.out.println("Wrong app name...");
    }
}

//Facade
class Ecosystem{
    private StreamingDevice streamingDevice;
    private SoundBar soundBar;
    private TV tv;
    public Ecosystem(){
        streamingDevice = new StreamingDevice();
        soundBar = new SoundBar();
        tv = new TV();
    }
    public void Choose(String input){
        tv.turnOn();
        soundBar.on();
        streamingDevice.startDevice();


        if(input.contains("Cinema")){
            soundBar.changeMod("Cinema");
        }
        else if(input.contains("Tv Show")){
            soundBar.changeMod("Tv Show");
        }
        if(input.contains("Netflix") ){
            streamingDevice.chooseApp("Netflix");
        }
        else if(input.contains("Exxen")){
            streamingDevice.chooseApp("Exxen");
        }
    }

}
