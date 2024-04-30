package hrms.utilities;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {

   // private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://192.168.1.46:8086");
  //  private static final String DATABASE = "selenium_logs";

	//private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://35.74.142.93:8086", "admin", "InfluxDBP@ssw0rd");
	//private static final String DATABASE = "14a9210b39a9f897";
	
	  private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://35.74.142.93:8087");
	  private static final String DATABASE = "selenium";
	
    static{
        INFLXUDB.setDatabase(DATABASE);
    }

    public static void send(final Point point){
        INFLXUDB.write(point);
    }

}
