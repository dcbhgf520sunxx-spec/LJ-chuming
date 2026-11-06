import { inject as T } from "vue";
import { ref as c } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as w } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as l } from "vue";
import { withKeys as P } from "vue";
import { withModifiers as E } from "vue";
import { createTextVNode as p } from "vue";
import { unref as h } from "vue";
import { toDisplayString as r } from "vue";
import { createElementBlock as H } from "vue";
import { createCommentVNode as $ } from "vue";
import { isRef as G } from "vue";
import { ElMessage as X } from "element-plus";
import { ElInput as J } from "element-plus";
import { ElTableColumn as O } from "element-plus";
import { ElImage as Y } from "element-plus";
import { ElInputNumber as Z } from "element-plus";
import { g as ee, a as le } from "../../../../../modules/parallel-config-554d8028.js";
import { _ as te, u as ae, o as oe, G as ie } from "../../../../../shared/runtime.js";
const se = { class: "head-container", style: { display: "flex", "justify-content": "space-between" } }, ne = { class: "board-box" }, re = { class: "error-slot" }, ue = { key: 0 }, de = { key: 1 }, ce = { __name: "pad-block-dialog", props: { visible: { type: Boolean, default: false }, padBlockData: { type: Array, default: () => [] } }, emits: ["update:visible", "success", "addBlock"], setup(W, { emit: Q }) {
  const U = T("permission"), B = Q, z = W, C = c([]), m = c(), f = c(), g = c(), _ = c(), y = c([]), k = c([]), { visible: v, handleClose: A } = ae({ emit: B, props: z, field: "visible", showHook: I }), { maxHeight: D } = oe({ mainBox: ".machine-part-scheduling-preview-dlg", extraBox: [".el-dialog__header", ".head-container"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, v);
  function I() {
    d();
  }
  L();
  async function L() {
    var o, t;
    k.value = [], y.value = [];
    try {
      const i = await ee();
      for (let n = 0; n < ((o = i == null ? void 0 : i.material) == null ? void 0 : o.length); n++) k.value.push({ value: i.material[n] });
      for (let n = 0; n < ((t = i == null ? void 0 : i.thick) == null ? void 0 : t.length); n++) y.value.push({ value: i.thick[n] });
    } catch (i) {
      console.log("获取厚度材质筛选", i);
    }
  }
  async function d() {
    console.log(f.value, m.value);
    try {
      const { content: o } = await le({ serialNumber: g.value, specification: _.value, material: f.value, thick: m.value });
      o == null || o.forEach((t) => {
        t.imgLoad = true, t.usedQuantity = 1;
      }), C.value = o || [];
    } catch (o) {
      console.log("获取标准零件列表信息失败", o);
    }
  }
  function M(o) {
    B("addBlock", o), X.success("您添加了 " + o.usedQuantity + " 件" + o.serialNumber + "标准零件");
  }
  function j() {
    g.value = void 0, _.value = void 0, f.value = void 0, m.value = void 0, d();
  }
  function K() {
    d();
  }
  return (o, t) => {
    const i = b("common-select"), n = J, x = b("common-button"), s = O, S = Y, q = Z, F = b("common-table"), R = b("common-dialog");
    return w(), N(R, { customClass: "pad-block-scheduling-preview-dlg", title: "标准零件排产预览", modelValue: h(v), "onUpdate:modelValue": t[4] || (t[4] = (e) => G(v) ? v.value = e : null), top: "5vh", width: "1500px", "before-close": h(A) }, { default: a(() => [u("div", se, [u("div", null, [l(i, { modelValue: f.value, "onUpdate:modelValue": t[0] || (t[0] = (e) => f.value = e), options: k.value, dataStructure: { key: "value", label: "value", value: "value" }, clearable: "", filterable: "", type: "other", class: "filter-item", placeholder: "请选择材质", style: { width: "160px" }, onChange: d }, null, 8, ["modelValue", "options"]), l(i, { modelValue: m.value, "onUpdate:modelValue": t[1] || (t[1] = (e) => m.value = e), options: y.value, dataStructure: { key: "value", label: "value", value: "value" }, clearable: "", filterable: "", type: "other", class: "filter-item", placeholder: "请选择厚度", style: { width: "160px" }, onChange: d }, null, 8, ["modelValue", "options"]), l(n, { modelValue: g.value, "onUpdate:modelValue": t[2] || (t[2] = (e) => g.value = e), placeholder: "输入编号搜索", class: "filter-item", style: { width: "160px" }, size: "default", clearable: "", onKeyup: P(d, ["enter"]) }, null, 8, ["modelValue"]), l(n, { modelValue: _.value, "onUpdate:modelValue": t[3] || (t[3] = (e) => _.value = e), placeholder: "输入规格搜索", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "", onKeyup: P(d, ["enter"]) }, null, 8, ["modelValue"]), l(x, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: E(K, ["stop"]) }, { default: a(() => t[5] || (t[5] = [p("搜索")])), _: 1, __: [5] }), l(x, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: E(j, ["stop"]) }, { default: a(() => t[6] || (t[6] = [p(" 重置 ")])), _: 1, __: [6] })])]), l(F, { data: C.value, "return-source-data": "", "show-empty-symbol": false, "max-height": h(D) - 160, style: { width: "100%" } }, { default: a(() => [l(s, { label: "序号", type: "index", align: "center", width: "60" }), l(s, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", "min-width": "80px", align: "left" }, { default: a(({ row: e }) => [u("span", null, r(e.serialNumber), 1)]), _: 1 }), l(s, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "80px", align: "left" }, { default: a(({ row: e }) => [u("span", null, r(e.specification), 1)]), _: 1 }), l(s, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, "min-width": "80px", align: "left" }, { default: a(({ row: e }) => [u("span", null, r(e.length), 1)]), _: 1 }), l(s, { key: "thick", prop: "thick", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [p(r(e.row.thick ? e.row.thick : "-"), 1)]), _: 1 }), l(s, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "left", "min-width": "80px" }, { default: a((e) => [p(r(e.row.material ? e.row.material : "-"), 1)]), _: 1 }), l(s, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: a((e) => [p(r(e.row.netWeight ? e.row.netWeight : "-"), 1)]), _: 1 }), l(s, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: a((e) => [p(r(e.row.grossWeight ? e.row.grossWeight : "-"), 1)]), _: 1 }), l(s, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `单面积
(㎡)`, align: "left", "min-width": "80px" }, { default: a((e) => [p(r(e.row.surfaceArea ? e.row.surfaceArea : "-"), 1)]), _: 1 }), l(s, { key: "picturePath", prop: "picturePath", label: "图片", align: "left", "min-width": "80px" }, { default: a((e) => [u("div", ne, [l(S, { src: e.row.picturePath, onError: (V) => e.row.imgLoad = false }, { error: a(() => [u("div", re, [e.row.picturePath ? (w(), H("span", ue, "加载失败")) : (w(), H("span", de, "未导入DXF"))])]), _: 2 }, 1032, ["src", "onError"])])]), _: 1 }), l(s, { prop: "quantity", label: "已套料数量", align: "left", width: "120px" }, { default: a(({ row: e }) => [u("span", null, r(e.quantity), 1)]), _: 1 }), l(s, { prop: "usedQuantity", label: "数量", align: "left", width: "120px", fixed: "right" }, { default: a(({ row: e }) => [l(q, { modelValue: e.usedQuantity, "onUpdate:modelValue": (V) => e.usedQuantity = V, step: 1, min: 1, max: 99999999, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), h(ie)(h(U).detailAdd) ? (w(), N(s, { key: 0, label: "操作", width: "70", align: "center", fixed: "right" }, { default: a((e) => [l(x, { type: "success", icon: "el-icon-plus", size: "default", onClick: (V) => M(e.row) }, null, 8, ["onClick"])]), _: 1 })) : $("", true)]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, he = te(ce, [["__scopeId", "data-v-e8f3b02e"]]);
export {
  he as default
};
