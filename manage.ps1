param (
    [Parameter(Mandatory=$true)]
    [ValidateSet("start", "stop", "status", "clean")]
    $Action
)

switch ($Action) {
    "start" {
        Write-Host "--- Start Services ---" -ForegroundColor Green
        docker compose up -d
    }
    "stop" {
        Write-Host "--- Stop Services ---" -ForegroundColor Yellow
        docker compose stop
    }
    "status" {
        Write-Host "--- Status ---" -ForegroundColor Magenta
        docker compose ps
    }
    "clean" {
        Write-Host "--- Full Cleanup ---" -ForegroundColor Red
        docker compose down -v
    }
}