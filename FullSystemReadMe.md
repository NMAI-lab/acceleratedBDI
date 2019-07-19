To run Gem5 in full system mode:

1-Follow Gem5 Image setup tutorial online (download image and configure files then mount it)
->If your image is has a different name than the one in the provided fullsysrun.sh file change linux-ryan2.img -> "yourimgname.img"

2-To add files, you have to edit the root file system (no internet access)
->This can be done by mounting the image outside of the simulation then simply copying files inside the root directory. This is how you get java up and running (download jdk tar file for X86 arch then extract it within the root system)

3-If you're using java in full system emulation mode copy the bashrc file into etc/bash pathway within the disk image. This contains the necessary pathways for java to be used.

4-run the fullsysrun.sh file within the gem5 directory

5-In a separate termninal run "telnet localhost 3456" to connect to port opened by the simulation

6-Wait and you will eventually be inside the full system simulation 



