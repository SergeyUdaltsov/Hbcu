variable "name" {
  type = string
  description = "Name instance"
}

variable "ami" {
  type = string
  description = "ID of AMI to use for the instance"
}

variable "instance_type" {
  type = string
  description = "The type of instance to start"
}

variable "key_name" {
  type = string
  description = "Key name of the Key Pair to use for the instance; which can be managed using the aws_key_pair resource"
}

variable "vpc_security_group_ids" {
  type = list(string)
  description = "A list of security group IDs to associate with"
}

variable "subnet_id" {
  type = string
  description = "The VPC Subnet ID to launch instance"
}

variable "tags" {
  type = map(string)
  description = "A mapping of tags to assign to the resource"
}
variable "m3_regionName" {
  description = "The AWS region to deploy"
  type = string
}