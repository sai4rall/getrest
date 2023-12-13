 downloadFile(data: Response | any) {
        const blob: Blob = data as Blob
        let link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = `example.xlsx`;
        link.click();
    }
