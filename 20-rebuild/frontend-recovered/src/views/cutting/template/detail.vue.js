import { ref as y } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as b } from "vue";
import { createBlock as v } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as w } from "vue";
import { unref as m } from "vue";
import { createTextVNode as r } from "vue";
import { createCommentVNode as D } from "vue";
import { createVNode as e } from "vue";
import { toDisplayString as s } from "vue";
import { createElementBlock as W } from "vue";
import { isRef as S } from "vue";
import { ElNotification as j } from "element-plus";
import { ElDescriptionsItem as q } from "element-plus";
import { ElTag as z } from "element-plus";
import { ElImage as H } from "element-plus";
import { ElDescriptions as L } from "element-plus";
import { ElTableColumn as T } from "element-plus";
import { _ as F, u as G, G as M } from "../../../shared/runtime.js";
import { b as O } from "../../../modules/cutting-457c256f.js";
import { b as X, d as A } from "../../../modules/project-data-5e9d497a.js";
const J = { key: 0 }, K = { __name: "detail", props: { visible: { type: Boolean, required: true }, detailData: { type: Object, required: true } }, emits: ["update:visible"], setup(a, { emit: k }) {
  const x = k, d = y([]), u = y([]), n = a, { visible: p, handleClose: C } = G({ emit: x, props: n, field: "visible", showHook: E });
  function E() {
    P(), U();
  }
  async function P() {
    d.value = await X(n.detailData.taskId), d.value === "没有零件" && (d.value = []);
  }
  async function U() {
    u.value = await A(n.detailData.taskId), u.value.forEach((c) => {
      c.platePictureUrlList = [], c.platePictureUrlList.push(c.platePictureUrl);
    });
  }
  function V() {
    n.detailData.dwgReportUrl !== null ? window.location.href = n.detailData.dwgReportUrl : j({ title: "下载失败", message: "暂无钢板图形 ", type: "error" });
  }
  return (c, i) => {
    const I = f("common-button"), o = q, R = z, h = H, N = L, t = T, _ = f("common-table"), B = f("common-drawer");
    return b(), v(B, { ref: "drawerRef", title: "查看零件余料", "custom-class": "section-steel-detail", modelValue: m(p), "onUpdate:modelValue": i[0] || (i[0] = (g) => S(p) ? p.value = g : null), direction: "rtl", "before-close": m(C), size: 1e3 }, { content: l(() => [i[2] || (i[2] = w("div", { class: "item-name", style: { float: "left" } }, "钢板信息", -1)), m(M)(m(O).downloadDrawing) ? (b(), v(I, { key: 0, disabled: a.detailData.dwgReportUrl === null, icon: "el-icon-download", onClick: V, type: "warning", size: "default", style: { float: "right" } }, { default: l(() => i[1] || (i[1] = [r("下载图形报告")])), _: 1, __: [1] }, 8, ["disabled"])) : D("", true), e(N, { column: 2, border: "" }, { default: l(() => [e(o, { label: "项目/单体", "label-align": "center", align: "center" }, { default: l(() => [r(s(a.detailData.projectName) + " ", 1), a.detailData.monomer ? (b(), W("span", J, s(a.detailData.monomer), 1)) : D("", true)]), _: 1 }), e(o, { label: "切割指令号", "label-align": "center", align: "center", "label-class-name": "my-label", "class-name": "my-content" }, { default: l(() => [r(s(a.detailData.cutInstructionId), 1)]), _: 1 }), e(o, { label: "规格（mm）", "label-align": "center", align: "center" }, { default: l(() => [r(s(a.detailData.thick + " X " + a.detailData.width + "*" + a.detailData.length), 1)]), _: 1 }), e(o, { label: "材质", "label-align": "center", align: "center" }, { default: l(() => [e(R, { size: "default" }, { default: l(() => [r(s(a.detailData.material), 1)]), _: 1 })]), _: 1 }), e(o, { style: { width: "200px", height: "100px" }, label: "钢板图形", "label-align": "center", align: "center" }, { default: l(() => [e(h, { style: { width: "100%", height: "100%" }, "preview-src-list": a.detailData.srcList, src: a.detailData.platePictureUrl, fit: "cover" }, null, 8, ["preview-src-list", "src"])]), _: 1 })]), _: 1 }), i[3] || (i[3] = w("div", { class: "item-name", style: { float: "left" } }, "零件信息", -1)), e(_, { ref: "tableRef", data: d.value, style: { width: "100%" } }, { default: l(() => [e(t, { prop: "index", label: "序号", align: "center", "min-width": "60", type: "index" }), e(t, { prop: "specification", label: "规格", align: "center", "min-width": "100" }), e(t, { prop: "length", label: "长度（mm）", align: "center", "min-width": "100" }), e(t, { prop: "material", label: "材质", align: "center", "min-width": "100" }), e(t, { prop: "quantity", label: "数量", align: "center", "min-width": "100" }), e(t, { prop: "netWeight", label: "单净重（kg）", align: "center", "min-width": "100" }), e(t, { prop: "grossWeight", label: "单毛重（kg）", align: "center", "min-width": "100" }), e(t, { prop: "totalNetWeight", label: "总净重（kg）", align: "center", "min-width": "100" }), e(t, { prop: "totalGrossWeight", label: "总毛重（kg）", align: "center", "min-width": "100" })]), _: 1 }, 8, ["data"]), i[4] || (i[4] = w("div", { class: "item-name", style: { float: "left" } }, "余料信息", -1)), e(_, { ref: "tableRef", style: { width: "100%" }, data: u.value }, { default: l(() => [e(t, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), e(t, { prop: "specification", label: "规格", align: "center", "min-width": "100" }), e(t, { prop: "material", label: "材质", align: "center", "min-width": "100" }), e(t, { prop: "weight", label: "重量（kg）", align: "center", "min-width": "100" }), e(t, { prop: "num", label: "数量", align: "center", "min-width": "100" }), e(t, { prop: "area", label: "面积", align: "center", "min-width": "100" }), e(t, { label: "图形", align: "center", "min-width": "100" }, { default: l((g) => [e(h, { style: { width: "100%", height: "100%" }, src: g.row.surplusPictureUrl, fit: "cover" }, null, 8, ["src"])]), _: 1 })]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = F(K, [["__scopeId", "data-v-f8e9d8d1"]]);
export {
  ee as default
};
