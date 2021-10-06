name                   = "udaltest"
ami                    = "Linux_Ubuntu_18"
instance_type          = "t2.micro"
key_name               = "dev2_m3server"
monitoring             = true
vpc_security_group_ids = ["sg-060a2ac72a63410a9"]
subnet_id              = "subnet-02b9bcfe64918fafb"
m3_regionName          = "eu-central-1"
tags = {
  Terraform   = "true"
  Environment = "dev"
}
