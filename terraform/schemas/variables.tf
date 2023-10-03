# VARS
# --------------------
variable "env_id" {
    type = string
}
variable "sr_cluster_id" {
    type = string
}
variable "app_manager_sr_key" {
    type = string
    sensitive = true
}
variable "app_manager_sr_secret" {
    type = string
    sensitive = true
}