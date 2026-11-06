import { openBlock as h } from "vue";
import { createElementBlock as r } from "vue";
import { withDirectives as b } from "vue";
import { vShow as D } from "vue";
import { createElementVNode as o } from "vue";
import { normalizeStyle as u } from "vue";
import { vModelText as k } from "vue";
import { withKeys as R } from "vue";
import { normalizeClass as C } from "vue";
import { Fragment as p } from "vue";
import { renderList as y } from "vue";
import { createVNode as c } from "vue";
import { toDisplayString as x } from "vue";
import { withModifiers as f } from "vue";
import { withCtx as T } from "vue";
import { createCommentVNode as B } from "vue";
import { Transition as S } from "vue";
import { ElColorPicker as E } from "element-plus";
import { ElSlider as V } from "element-plus";
import { CaretTop as W } from "@element-plus/icons-vue";
import { ElIcon as U } from "element-plus";
import { _ as Y, a as P } from "../../../../../shared/runtime.js";
const _ = { pen: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACd0lEQVRYR+2WT2gTQRTGv7eb9JLkmPoHvHkQLy2i94o0KMiyMxgRbwrmpigeFBUJFPHiRegpgiLiQZbMTFoR/4AX7UVQCD14EfGcQkGFiia7T0Yq1HWTbLeGgnSOszPv9/HNex9L2ORFm8zHloD/1gHyff8cEZ0EEAIIyuXybKPR6MZ7biQOCCEaAM6shRHRrFLq7MgF+L5/nIgexUHMHOXz+XIQBMt/CPuXY+h53m7Xdd8BKPWpO6m1bo9EQLVaHet2uwtEtL8P/HMul9sRBMG3kQjwff8WEV3sA2cAp7TW90fSA0KIwwCeAInBxsx8wRhzO0nchqdACDEeRVHbcZztCQA7gjWt9d1+vbYhAfV63Wm3208BTCcAekR0Win1YFCjb0iAEOIygJsJgB9EdEIppYdNWWYBUsoDzPwawFgMssLMwhjzfBjcfs8sQAjRBCBjkC9RFB1ttVqv0sBTC6hUKoVisSiZeS8RPVZKLQghbNTayP29lpn5iDHmTVp4KgGrVhsAO1cLv9RaH7LuSSlvMPN5AF8BVOIpl0bIwCeoVqvlXq+3CGDbmmI2VI5prZXdm5qaypVKpbH5+fmVNMB1BZGUcoaZr8UvMXPXcZx7RHSn2Wy+BWBFZVp9HajVavmlpaVPa6xPBBDRdaXUTCZ6vynwPK/kuu4lAFeHFWbmK8aYpCwYdvXX978ckFLuY2Zra9plm+9F2sNDe8COXKFQ+AhgPEXRxYmJicl6vR6lOJv8hEm71oUwDB86jrNnQOH3YRh6c3NzH7LCB+aAbcJOp3OQiKaZeRcRWUe+A+gQ0TPXdXX85yKLkMxRnAWWdGdLwJYDPwFn/dQhz4OkVwAAAABJRU5ErkJggg==", line: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAA4klEQVRYR+3WTQrCMBCG4fmy8AYeyo2kBS+goAsPJPhzhTEIHso7SEa6EETsXzJjN+m+vE8nhQlo4gcT96kAygRMJ1BV1RrAg5nvbT+7GaCJi8gJwBPAiplvvxAmAO/9hoiOAJyIRCLahhAufwF8fLkjIhGRfQjh8JcjGBtvUGpHkBJXA6TGVQA58WxAbjwLoBFPBmjFkwCa8dEA7fgogEV8MMAqPghgGe8FWMc7Ad8r1Tm3Y+az9i26dRl57xcArkQ061upOajObVjX9TLGOG+7TOSE3++qreNUTAGUCUw+gRcF0dchsIjssQAAAABJRU5ErkJggg==", round: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACpUlEQVRYR+2WPW8TQRCG39mLqUBQuKQiCeJDSiT4DRCFwtk964KQ6BCWoCUfonMJOD1gRAkCjG/ODUmB+AcgpQECCVW6NBFQYecGbbSHEhPfnZ0ijbezduedx7PvzhzhiBcdcX4MAYYV6KsCQRAc29nZMSIyA+ASEZ22JhaRTQCfRCQqFApRo9H4k9fcuQG01mUiegTgTIb4BoAFZg7zQGQCBEHgtdvth0R0r0twTUQ2iMhqjAI427W/NDk5uVitVuM0kEwArfXSnuQdInpGREvNZvPHXuFSqTQ2MjIyLyK3AHhur8bMCwMDuLK/dQLbAMrM/CFN0BhzBUADwEnnDxNFUdQrpmcFrOE6nc4Xd+cdAFNZyZMkWuurRPTOVoKI1j3Pu9jLmD0BfN+/LiKvrCgRPQ7D8G4eUyVnjDF1ALfd71lmtlX5b/UEMMa8BHDDRiilRrvvPAumXC6Px3H8zZ17wcw3+wVYs86O4/hrq9U6n5XwoH1jjAUYB7DGzOf6BfgF4DiAZWa+NgiA1nqFiKYA/GbmE4MCrDDz9CEBfjLz7qvoXmke2L2CtPJlQRljMjVymVBExqIosi0297KNyfO87wObUGs9S0SvncATZr6TOzsA3/efikjFPeMgDMOkoe2TyWpEn12f7yilppvN5vs8EK4bLieNqFgsXqjX6+2+PGAPG2N8AE0XuK2UCrIgXPI3AE65OM3MrV7gmcPIGFMDMOcEbEt+LiK1bk8cNIzs+A7DcDGtapkA1WpVra6uPgAw3yVkm4w1ZjKObcP5t2zyiYmJ+4cex4mi1lorpWr2RaT+I6J1EZlLK/s+0DymSs5UKpXC1taWBjATx/FlpdTuJ1kcx5tKqY9EFBWLxVYvw/Vtwn7gBj2b6YFBhfPGDQGGFfgLW7AHMIfxtKYAAAAASUVORK5CYII=", trangle: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAl0lEQVRYR+2WsQ2DMBBF/w1BaLIIW/gKGJIU31uwCJUzhFGKVIAEjiUr0nd/95+f5DsbGh9rnA8ByIAMnBoIISQz62o805zzO8b4OOp1CuDuuUb4twfJw6wrACuApRBmAPD81P4C8CI5lQC4+wxgFIAMyIAM/L2B5qO4ZArvam7vgprrGEAi2d9ax1WufaGJvmQyIAPNDWzonXsh3WqxKQAAAABJRU5ErkJggg==", eraser: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAACaElEQVRYR+2Uv4sTQRTHv28ymKBYqAg2WolYJYKCWByiicGoIRvDdlcE4x9gb5PCWtDK7mxOi3Uzk6RT8VrxB/7qD1s5jyOgiLi7TwY2sIb8mM0WB3LTznvv+5nve/MIu3xol/WxB/B/ONButwuj0egOgGNCiIe+72/azlZmB2q1Wr5QKPgArhtRZt5i5nK/3/9iA5EJYFJ8LJgGYmmAWeJJiFwuV/F9//M8J5YCWCSeENxh5ita6/ezIFIDuK67LwgC0/MbNj0GsCOEqPq+/25afCqAeNoVgKuW4uOwbWauaK0/TuZZA2QQH2tuKqVOmo+ShLACiHtuXn4+Tj6c0gETHkopD3qe9ysVgBHP5/M9IrpARJX4r78AkBbigVLKLKt/zlwHzMCFYfiMmVeIqNrr9d6abMdxzhDRSwBHLJ1YK5VKt7vdbmQNEE+7B+AiM1e11m+SySkgZoqbelMdWCQ+BrGAmCs+E8BxnHUiupa0fZbVjuOcJSIzE4cmYhaKTwWo1+v7pZQ/AHSUUms2PW61WueiKHo+hiCix8VisTOt51Yz0Gw2PwEQUsrLnudt2UA0m827AO6lEZ83AyeCINgA8DsMw0uDweDbPAjHcVoAnhKRL6Vc9TwvtIGeCWAuXNc1EK8A/AyCoDwcDr9PK5pFfC6AuWw0GseFEMYJMxNlpdT2xFdc+uXjOgtXcezEBjOPANzUWn+Nl1GHiB4BeCKlvJXG9lSrOOGEBnA6iqIPQoijAE4x8x8iGpo9b9Hz10qp+1a/YFqxeDmtEtEKMx+wEJwMyQawhKBVysIZsKqSIWgPYNcd+AsPkxIwA3VPaAAAAABJRU5ErkJggg==", text: "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAA5klEQVRYR+2VPwrCMBSHfwlFvIizq6u7y0vR2Qt4A0dP4AmcLSUUhI6Ozs5epA5NpKBQ1Ni0tAThZUxe8r735Z9A4CYC5wcDsAGngTiOJ8aYRR+HVEp5StP09m0tJwARLQEc+wAAsNJaJ38NsDXGnOsVSCnnAHbPvqbxTgam1tp1lUAIcdBaX+sAb1v0kYCIfs5/rdX5GjYB+J4dBmADbIANsIHWBpRSs7IspeszyrLsAsAO9hQT0R3AyJWgKIpxnudVjFdrbSA4gFJqY62NXOVFUbRPkqT0Kr/66n0Dh4pjADYQ3MADakKSIQVRq+oAAAAASUVORK5CYII=" };
const Q = { name: "SimpleDrawing", props: { initConfig: { type: Object, default: () => ({ bgColor: "#ffffff", strokeColor: "#333333", width: 400, height: 400 }) }, reset: { type: Boolean, default: true } }, computed: { boardStyle() {
  return { width: this.currentImg.width + "px", height: this.currentImg.height + "px" };
}, canvasStyle() {
  return { cursor: this.cursor, width: this.currentImg.width, height: this.currentImg.height, padding: "30px" };
} }, watch: { reset: { handler(s) {
  s && this.canvas_front && this.handleClearCanvas();
}, immediate: true } }, data() {
  return { defaultColor: "#333333", bgColor: "#ffffff", cursor: `url('${_.pen}'),auto`, slide: 1, settings: [{ icon: "paint", name: "颜色", fun: "" }, { icon: "pen", name: "粗细", fun: "" }], activeTool: 1, tools: [{ icon: "pen", name: "画笔", toolType: 1 }, { icon: "line", name: "直线", toolType: 2 }, { icon: "circle", name: "圆形", toolType: 3 }, { icon: "square", name: "矩形", toolType: 4 }, { icon: "eraser", name: "橡皮", toolType: 5 }, { icon: "text", name: "文字", toolType: 6 }], btns: [{ icon: "pre", name: "上一步", fun: () => this.handlePrev() }, { icon: "next", name: "下一步", fun: () => this.handleNext() }, { icon: "delete", name: "清除", fun: () => this.handleClearCanvas() }, { icon: "document", name: "保存", fun: () => this.handleCanvas2Img() }], canvas_front: null, canvas_back: null, canvas_base: null, ctx_base: null, ctx_front: null, ctx_back: null, canvasWidth: 400, canvasHeight: 400, currentImg: { url: void 0, width: 800, height: 800, scale: 1, index: -1 }, isExpand: 1, showTools: 1, canDraw: false, text: "", canvasStore: [], prevDis: true, nextDis: true, tl: 0, tt: 0, deleteShow: false, deleteX: 0, deleteY: 0, deleteWidth: 0, deleteHeight: 0 };
}, created() {
  this.canvasWidth = this.initConfig.width || 400, this.canvasHeight = this.initConfig.height || 400, this.defaultColor = this.initConfig.strokeColor || "#333333", this.bgColor = this.initConfig.bgColor || "#ffffff";
}, methods: { handleShowOrHide(s) {
  this.isExpand = s;
}, handleShowTools(s) {
  this.showTools = s;
}, handleChangeToolType(s) {
  switch (this.activeTool = s, s) {
    case 1:
      this.cursor = `url('${_.pen}'),auto`;
      break;
    case 2:
      this.cursor = "default";
      break;
    case 3:
      this.cursor = "crosshair";
      break;
    case 4:
      this.cursor = "crosshair";
      break;
    case 5:
      this.cursor = `url('${_.eraser}'),auto`;
      break;
    case 6:
      this.cursor = `url('${_.text}'),auto`;
      break;
    case 7:
      this.cursor = "crosshair";
      break;
    default:
      this.cursor = `url('${_.pen}'),auto`;
      break;
  }
  this.handleDrawCanvas(s);
}, handleInitCanvas() {
  this.currentImg = { url: void 0, width: this.canvasWidth, height: this.canvasHeight, scale: 1, index: -1 }, this.canvasStore = [], this.prevDis = true, this.nextDis = true, this.canvas_front = document.getElementById("ctx_front"), this.canvas_back = document.getElementById("ctx_back"), this.canvas_base = document.getElementById("ctx_base"), this.ctx_base = this.canvas_base.getContext("2d"), this.ctx_front = this.canvas_front.getContext("2d"), this.ctx_back = this.canvas_back.getContext("2d"), this.ctx_front.strokeStyle = this.defaultColor;
  const s = this.currentImg.width, t = this.currentImg.height;
  this.canvas_front.width = s, this.canvas_front.height = t, this.canvas_back.width = s, this.canvas_back.height = t, this.canvas_base.width = s, this.canvas_base.height = t, this.ctx_base.fillStyle = this.bgColor, this.ctx_back.fillStyle = this.bgColor, this.ctx_base.fillRect(0, 0, s, t), this.ctx_back.fillRect(0, 0, s, t), this.ctx_front.setLineDash([0]), this.selectCancel();
}, handleCanvasSizeChange() {
  const s = this.currentImg.width, t = this.currentImg.height, n = this.canvasWidth, l = this.canvasHeight;
  if (n < 1 || n > 2e3 || l < 1 || l > 2e3) {
    this.canvasWidth = s, this.canvasHeight = t, this.$message({ message: "长宽不可小于1像素或大于2000像素", type: "warning" });
    return;
  }
  this.ctx_front.clearRect(0, 0, s, t), this.ctx_back.clearRect(0, 0, s, t), this.ctx_base.clearRect(0, 0, s, t), this.currentImg.width = n, this.currentImg.height = l, this.canvas_front.width = n, this.canvas_front.height = l, this.canvas_back.width = n, this.canvas_back.height = l, this.canvas_base.width = n, this.canvas_base.height = l, this.ctx_base.fillStyle = this.bgColor, this.ctx_back.fillStyle = this.bgColor, this.ctx_base.fillRect(0, 0, n, l), this.ctx_back.fillRect(0, 0, n, l);
  const i = this, a = new Image();
  a.src = this.currentImg.url, a.onload = function() {
    i.ctx_front.drawImage(this, 0, 0), i.ctx_back.drawImage(this, 0, 0);
  };
}, handleDrawImage() {
  const s = this, t = new Image();
  t.src = this.currentImg.url;
  const n = this.currentImg.width = this.currentImg.width * this.currentImg.scale, l = this.currentImg.height = this.currentImg.height * this.currentImg.scale;
  this.currentImg.url ? t.onload = function() {
    s.canvas_front.width = n, s.canvas_front.height = l, s.canvas_back.width = n, s.canvas_back.height = l, s.ctx_back.drawImage(this, 0, 0);
  } : (s.ctx_front.clearRect(0, 0, n, l), s.ctx_back.clearRect(0, 0, n, l), this.ctx_base.fillStyle = this.bgColor, this.ctx_back.fillStyle = this.bgColor, this.ctx_base.fillRect(0, 0, n, l), this.ctx_back.fillRect(0, 0, n, l));
}, handleBeLarge() {
  this.currentImg.scale = 1, this.currentImg.scale += 0.1, this.$nextTick(() => {
    this.handleDrawImage();
  });
}, handleBeSmall() {
  this.currentImg.scale = 1, this.currentImg.scale -= 0.1, this.$nextTick(() => {
    this.handleDrawImage();
  });
}, handleCanvas2Img() {
  const s = document.getElementById("ctx_back");
  this.$emit("download", s.toDataURL()), this.handleClearCanvas();
}, handleClearCanvas() {
  this.handleInitCanvas();
}, handleFrommatCanvas() {
  this.ctx_front.clearRect(0, 0, this.canvas_front.width, this.canvas_front.height);
}, handleDrawCanvas(s) {
  this.canDraw = false;
  let t, n, l, i, a = 0, d = 0;
  const g = document.getElementById("text"), w = (e) => {
    s === 7 ? this.ctx_front.strokeStyle = "red" : this.ctx_front.strokeStyle = this.defaultColor, this.ctx_front.lineWidth = this.slide, this.ctx_front.setLineDash([0]), e = e || window.event;
    const A = this.canvas_front.getBoundingClientRect();
    a = A.top, d = A.left, t = e.clientX - d + this.$refs.body.scrollLeft, n = e.clientY - a + this.$refs.body.scrollTop;
    const m = this.ctx_base.getImageData(e.offsetX - this.slide / 2, e.offsetY - this.slide / 2, this.slide * 6, this.slide * 6);
    switch (this.ctx_front.moveTo(t, n), this.canDraw = true, s) {
      case 1:
        this.ctx_front.beginPath();
        break;
      case 5:
        this.ctx_front.putImageData(m, e.offsetX - this.slide / 2, e.offsetY - this.slide / 2);
        break;
      case 6:
        this.handleTextBlur(), this.text = "", g.style.fontSize = 14 + this.slide * 10 + "px", g.style.color = this.defaultColor, g.style.left = e.offsetX - this.$refs.body.scrollLeft + 5 + "px", g.style.top = e.offsetY - this.$refs.body.scrollTop + "px", g.style.zIndex = 10, g.style.display = "block", this.tl = e.offsetX - 25 + this.slide, this.tt = e.offsetY - 15 + this.slide * 10, console.log("this.tt", this.tt), setTimeout(() => {
          this.$refs.text.focus();
        }, 0);
        break;
    }
  }, I = (e) => {
    e = e || window.event, l = e.clientX - d + this.$refs.body.scrollLeft, i = e.clientY - a + this.$refs.body.scrollTop;
    const A = this.ctx_base.getImageData(e.offsetX - this.slide / 2, e.offsetY - this.slide / 2, this.slide * 6, this.slide * 6);
    if (this.canDraw) switch (s) {
      case 1:
        this.ctx_front.lineTo(l - 25, i - 5), this.ctx_front.stroke();
        break;
      case 2:
        this.handleFrommatCanvas(), this.ctx_front.beginPath(), this.ctx_front.moveTo(t - 30, n - 30 + this.slide / 2), this.ctx_front.lineTo(l - 30, i - 30 + this.slide / 2), this.ctx_front.stroke();
        break;
      case 3:
        this.handleFrommatCanvas(), this.ctx_front.beginPath();
        const m = Math.sqrt((t - 10 - l) * (t - 10 - l) + (n - 10 - i) * (n - 10 - i));
        this.ctx_front.arc(t - 27, n - 27, m, 0, Math.PI * 2, false), this.ctx_front.stroke();
        break;
      case 4:
        this.handleFrommatCanvas(), this.ctx_front.beginPath(), this.ctx_front.moveTo(t - 30, n - 30 - this.slide / 2), this.ctx_front.lineTo(l - 30 - this.slide / 2, n - 30 - this.slide / 2), this.ctx_front.lineTo(l - 30 - this.slide / 2, i - 30 - this.slide / 2), this.ctx_front.lineTo(t - 30 - this.slide / 2, i - 30 - this.slide / 2), this.ctx_front.lineTo(t - 30 - this.slide / 2, n - 30 - this.slide), this.ctx_front.stroke();
        break;
      case 5:
        this.ctx_front.putImageData(A, e.offsetX - this.slide / 2 - 20, e.offsetY - this.slide / 2 - 20);
        break;
      case 7:
        this.handleFrommatCanvas(), this.ctx_front.lineWidth = 2, this.ctx_front.beginPath(), this.ctx_front.setLineDash([5]), this.ctx_front.moveTo(t - 30, n - 30 - this.ctx_front.lineWidth / 2), this.ctx_front.lineTo(l - 30 - this.ctx_front.lineWidth / 2, n - 30 - this.ctx_front.lineWidth / 2), this.ctx_front.lineTo(l - 30 - this.ctx_front.lineWidth / 2, i - 30 - this.ctx_front.lineWidth / 2), this.ctx_front.lineTo(t - 30 - this.ctx_front.lineWidth / 2, i - 30 - this.ctx_front.lineWidth / 2), this.ctx_front.lineTo(t - 30 - this.ctx_front.lineWidth / 2, n - 30 - this.ctx_front.lineWidth), this.ctx_front.stroke();
        break;
    }
  }, v = () => {
    this.canDraw && (this.canDraw = false, this.ctx_front.closePath(), s === 7 ? (this.deleteX = t - 30, this.deleteY = n - 30 - this.ctx_front.lineWidth / 2, this.deleteWidth = l - t - this.ctx_front.lineWidth, this.deleteHeight = i - n, this.deleteShow = true) : s !== 6 && (console.log("非文字存储"), this.handleSaveCanvasStore()));
  };
  this.canvas_front.onmousedown = (e) => w(e), this.canvas_front.onmousemove = (e) => I(e), this.canvas_front.onmouseup = (e) => v(), this.canvas_front.onmouseout = (e) => v(), this.canvas_front.onmouseleave = (e) => v();
}, selectDelete() {
  this.ctx_front.clearRect(0, 0, this.canvas_front.width, this.canvas_front.height);
  const s = this.ctx_base.getImageData(this.deleteX, this.deleteY, this.deleteWidth, this.deleteHeight);
  this.ctx_front.putImageData(s, this.deleteX, this.deleteY), this.handleSaveCanvasStore(), this.deleteX = 0, this.deleteY = 0, this.deleteWidth = 0, this.deleteHeight = 0, this.deleteShow = false, this.handleChangeToolType(1);
}, selectCancel() {
  this.deleteX = 0, this.deleteY = 0, this.deleteWidth = 0, this.deleteHeight = 0, this.ctx_front.clearRect(0, 0, this.canvas_front.width, this.canvas_front.height), this.deleteShow = false, this.handleChangeToolType(1);
}, handleTextBlur() {
  const s = document.getElementById("text");
  this.ctx_front.font = `300 ${s.style.fontSize} sans-serif`, this.ctx_front.fillStyle = this.defaultColor, this.ctx_front.fillText(this.text, this.tl, this.tt), s.style.display = "none", this.text = "", s.value = "", this.handleSaveCanvasStore();
}, handlePrev() {
  this.currentImg.index >= 0 ? (this.nextDis = false, this.currentImg.index -= 1, this.prevDis = this.currentImg.index < 0, this.currentImg.url = this.prevDis ? void 0 : this.canvasStore[this.currentImg.index], this.currentImg.scale = 1, this.handleDrawImage()) : this.prevDis = true;
}, handleNext() {
  this.currentImg.index < this.canvasStore.length - 1 ? (this.prevDis = false, this.currentImg.index += 1, this.nextDis = this.currentImg.index === this.canvasStore.length - 1, this.currentImg.url = this.canvasStore[this.currentImg.index], this.currentImg.scale = 1, this.handleDrawImage()) : this.nextDis = true;
}, handleSaveCanvasStore() {
  const s = this.canvas_front.toDataURL(), t = new Image();
  t.src = s, t.onload = () => {
    this.ctx_front.clearRect(0, 0, this.canvas_front.width, this.canvas_front.height), this.ctx_front.drawImage(t, 0, 0, t.width, t.height), this.ctx_back.drawImage(t, 0, 0, t.width, t.height);
    const n = this.canvas_back.toDataURL();
    this.currentImg.url = n, this.currentImg.index += 1, this.canvasStore.push(n), this.prevDis = false;
  };
} }, mounted() {
  this.$nextTick(() => {
    this.handleInitCanvas(), this.handleChangeToolType(1);
  });
} }, K = { class: "imgDraw" }, O = { href: "javascript:void(0);", ref: "download", download: "picture.png" }, M = { class: "d_body", ref: "body" }, H = { class: "board", ref: "board" }, F = { class: "tool_item size_setting" }, z = { key: 0 }, G = { key: 1, class: "slide" }, L = { style: { color: "#fff" } }, X = ["onClick"], J = { class: "tool_item", style: { width: "60px" } }, N = ["onClick", "disabled"], j = ["onClick", "disabled"], q = ["onClick"], Z = { class: "tool_item go_up" }, $ = { key: 0, class: "pull" }, tt = { class: C(["tools", "bars"]) }, et = { key: 0, class: "right_tool", style: { "min-height": "300px" } }, st = { key: 0, class: "right_tool" }, it = ["onClick"];
function nt(s, t, n, l, i, a) {
  const d = P, g = E, w = V, I = W, v = U;
  return h(), r("div", K, [b(o("a", O, null, 512), [[D, false]]), o("div", M, [o("div", H, [o("div", { style: u([{ position: "absolute" }, a.boardStyle]) }, [o("canvas", { id: "ctx_front", ref: "ctx_front", style: u(a.canvasStyle) }, null, 4), o("canvas", { id: "ctx_base", ref: "ctx_base", style: u(a.canvasStyle) }, null, 4), o("canvas", { id: "ctx_back", ref: "ctx_back", style: u(a.canvasStyle) }, null, 4), b(o("input", { ref: "text", name: "text", id: "text", class: "text-input", onBlur: t[0] || (t[0] = (...e) => a.handleTextBlur && a.handleTextBlur(...e)), onKeyup: t[1] || (t[1] = R((...e) => a.handleTextBlur && a.handleTextBlur(...e), ["enter"])), "onUpdate:modelValue": t[2] || (t[2] = (e) => i.text = e), autofocus: "", autocomplete: "off", style: u("font-size:" + (this.slide * 10 + 14) + "px;color:" + i.defaultColor) }, null, 36), [[k, i.text]])], 4)], 512), o("div", { class: C(["top_tools", "tools", "settings", i.isExpand ? "" : "noExpand"]) }, [o("div", F, [b(o("input", { id: "canvas_width", "onUpdate:modelValue": t[3] || (t[3] = (e) => i.canvasWidth = e), onBlur: t[4] || (t[4] = (...e) => a.handleCanvasSizeChange && a.handleCanvasSizeChange(...e)) }, null, 544), [[k, i.canvasWidth, void 0, { number: true }]]), t[16] || (t[16] = o("span", null, "x", -1)), b(o("input", { id: "canvas_height", "onUpdate:modelValue": t[5] || (t[5] = (e) => i.canvasHeight = e), onBlur: t[6] || (t[6] = (...e) => a.handleCanvasSizeChange && a.handleCanvasSizeChange(...e)) }, null, 544), [[k, i.canvasHeight, void 0, { number: true }]])]), (h(true), r(p, null, y(i.settings, (e, A) => (h(), r("div", { class: "tool_item", key: e.icon }, [A == 0 ? (h(), r("button", z, [c(d, { "icon-class": e.icon, style: u("color:" + i.defaultColor) }, null, 8, ["icon-class", "style"]), o("span", { style: u("color:" + i.defaultColor) }, x(e.name), 5), c(g, { modelValue: i.defaultColor, "onUpdate:modelValue": t[7] || (t[7] = (m) => i.defaultColor = m) }, null, 8, ["modelValue"])])) : A == 1 ? (h(), r("div", G, [o("span", L, x(e.name), 1), c(w, { ref_for: true, ref: "slide", modelValue: i.slide, "onUpdate:modelValue": t[8] || (t[8] = (m) => i.slide = m), min: 1, max: 10, step: 1 }, null, 8, ["modelValue"])])) : (h(), r("button", { key: 2, onClick: f(e.fun, ["stop"]) }, [c(d, { "icon-class": e.icon }, null, 8, ["icon-class"]), o("span", null, x(e.name), 1)], 8, X))]))), 128)), o("div", J, [o("button", { onClick: t[9] || (t[9] = f((e) => a.handleChangeToolType(7), ["stop"])) }, "选择")]), (h(true), r(p, null, y(i.btns, (e) => (h(), r("div", { class: "tool_item", key: e.icon }, [e.name == "上一步" ? (h(), r("button", { key: 0, onClick: f(e.fun, ["stop"]), disabled: i.prevDis, style: u(i.prevDis ? "cursor:not-allowed" : "") }, [c(d, { "icon-class": e.icon }, null, 8, ["icon-class"]), o("span", null, x(e.name), 1)], 12, N)) : e.name == "下一步" ? (h(), r("button", { key: 1, onClick: f(e.fun, ["stop"]), disabled: i.nextDis, style: u(i.nextDis ? "cursor:not-allowed" : "") }, [c(d, { "icon-class": e.icon }, null, 8, ["icon-class"]), o("span", null, x(e.name), 1)], 12, j)) : (h(), r("button", { key: 2, onClick: f(e.fun, ["stop"]) }, [c(d, { "icon-class": e.icon }, null, 8, ["icon-class"]), o("span", null, x(e.name), 1)], 8, q))]))), 128)), o("div", Z, [o("button", { onClick: t[10] || (t[10] = f((e) => a.handleShowOrHide(0), ["stop"])) }, [c(v, null, { default: T(() => [c(I)]), _: 1 }), t[17] || (t[17] = o("span", null, "收起", -1))])]), i.isExpand ? B("", true) : (h(), r("div", $, [t[18] || (t[18] = o("span", { class: "line" }, null, -1)), o("span", { class: "round", title: "展开", onClick: t[11] || (t[11] = f((e) => a.handleShowOrHide(1), ["stop"])) })]))], 2), o("div", tt, [i.deleteShow ? (h(), r("div", et, [t[21] || (t[21] = o("div", { style: { background: "#f38c8c", color: "#fff", padding: "3px" } }, "选择", -1)), o("div", { class: C(["tool_item", i.activeTool == "delete" ? "activeTool" : ""]), onClick: t[12] || (t[12] = f((...e) => a.selectDelete && a.selectDelete(...e), ["stop"])) }, [c(d, { "icon-class": "delete" }), t[19] || (t[19] = o("span", null, "删除", -1))], 2), o("div", { class: C(["tool_item", i.activeTool == "delete" ? "activeTool" : ""]), style: { "border-bottom": "1px solid #dddddd" }, onClick: t[13] || (t[13] = f((...e) => a.selectCancel && a.selectCancel(...e), ["stop"])) }, [c(d, { "icon-class": "cancel" }), t[20] || (t[20] = o("span", { style: { "vertical-align": "1px" } }, "取消", -1))], 2)])) : (h(), r(p, { key: 1 }, [i.showTools ? (h(), r("div", { key: 1, class: "el-icon-arrow-right arrow", title: "收起", onClick: t[15] || (t[15] = f((e) => a.handleShowTools(0), ["stop"])) })) : (h(), r("div", { key: 0, class: "el-icon-s-tools arrow", title: "展开", onClick: t[14] || (t[14] = f((e) => a.handleShowTools(1), ["stop"])) })), c(S, { name: "slide-fade", appear: "" }, { default: T(() => [i.showTools ? (h(), r("div", st, [t[22] || (t[22] = o("div", { style: { background: "#f38c8c", color: "#fff", padding: "3px" } }, "工具", -1)), (h(true), r(p, null, y(i.tools, (e) => (h(), r("div", { class: C(["tool_item", i.activeTool == e.toolType ? "activeTool" : ""]), key: e.toolType, onClick: f((A) => a.handleChangeToolType(e.toolType), ["stop"]) }, [c(d, { "icon-class": e.icon }, null, 8, ["icon-class"]), o("span", null, x(e.name), 1)], 10, it))), 128))])) : B("", true)]), _: 1 })], 64))])], 512)]);
}
const rt = Y(Q, [["render", nt], ["__scopeId", "data-v-685f9aed"]]);
export {
  rt as default
};
