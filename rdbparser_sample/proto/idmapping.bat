echo "protoc version:"
.\protoc-3.10.0.exe --version
echo "protoc exc:"
.\protoc-3.10.0.exe -I=.\ --java_out=..\src\main\java\ .\idmapping.proto
.\protoc-3.10.0.exe -I=.\ --python_out=. .\idmapping.proto
pause