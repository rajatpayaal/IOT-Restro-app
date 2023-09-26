#include "appd_iot_interface.h"   
  ....
{
  // Declare config variables for the SDK and device.
  appd_iot_sdk_config_t sdkcfg;
  appd_iot_device_config_t devcfg;
  appd_iot_init_to_zero(&sdkcfg, sizeof(sdkcfg));
  appd_iot_init_to_zero(&devcfg, sizeof(devcfg));
 
  // Set the initialization configurations for the SDK
  sdkcfg.appkey = "<EUM_APP_KEY>";
 
  // Set the device configurations
  devcfg.device_id = "1111";
  devcfg.device_type = "SmartCar";
  devcfg.device_name = "AudiS3";
 
  // Initialize the instrumentation
  appd_iot_init_sdk(sdkcfg, devcfg);
}
