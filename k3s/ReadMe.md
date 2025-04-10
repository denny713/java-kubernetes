Testing and Debugging:
- Check all pod:
    kubectl get pods -n my-app
- Check pod logs:
    kubectl logs -f <nama-pod> -n my-app
- Forward port for producers:
    kubectl port-forward svc/producers 7070:7070 -n my-app

Access: http://localhost:7070