import { ref as h } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as p } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as r } from "vue";
import { createVNode as t } from "vue";
import { unref as m } from "vue";
import { toDisplayString as l } from "vue";
import { createTextVNode as n } from "vue";
import { createElementBlock as w } from "vue";
import { withModifiers as A } from "vue";
import { isRef as D } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElImage as R } from "element-plus";
import { ElInputNumber as z } from "element-plus";
import { _ as M, u as Q, o as U } from "../../../../../shared/runtime.js";
const j = { class: "board-box" }, L = { class: "error-slot" }, T = { key: 0 }, $ = { key: 1 }, F = { __name: "pad-block", props: { visible: { type: Boolean, default: false }, padBlockData: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(g, { emit: b }) {
  const x = h(), s = h([]), k = b, f = g, { visible: d, handleClose: v } = Q({ emit: k, props: f, field: "visible", showHook: y });
  function y() {
    s.value = f.padBlockData;
  }
  function B(_) {
    const i = s.value.findIndex((o) => o.id === _);
    s.value.splice(i, 1);
  }
  const { maxHeight: V } = U({ mainBox: ".drawer-detail", extraBox: [".el-drawer__header", ".head-container", ".remark-detail"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, minHeight: 300, extraHeight: 80 }, d);
  return (_, i) => {
    const o = P, H = R, W = z, C = c("common-button"), E = c("common-table"), I = c("common-drawer");
    return p(), N(I, { ref_key: "drawerRef", ref: x, title: "标准零件列表", modelValue: m(d), "onUpdate:modelValue": i[0] || (i[0] = (e) => D(d) ? d.value = e : null), direction: "rtl", "before-close": m(v), size: "75%", "custom-class": "drawer-detail" }, { content: a(() => [i[1] || (i[1] = r("div", { class: "head-container" }, null, -1)), t(E, { data: s.value, "return-source-data": "", "max-height": m(V), style: { width: "100%" } }, { default: a(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { "show-overflow-tooltip": true, prop: "serialNumber", label: "编号", "min-width": "80px", align: "left" }, { default: a(({ row: e }) => [r("span", null, l(e.serialNumber), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "specification", label: "规格", "min-width": "80px", align: "left" }, { default: a(({ row: e }) => [r("span", null, l(e.specification), 1)]), _: 1 }), t(o, { "show-overflow-tooltip": true, prop: "length", label: `长度
(mm)`, "min-width": "80px", align: "left" }, { default: a(({ row: e }) => [r("span", null, l(e.length), 1)]), _: 1 }), t(o, { key: "thick", prop: "thick", sortable: "custom", "show-overflow-tooltip": true, label: `厚度
(mm)`, align: "left", "min-width": "85px" }, { default: a((e) => [n(l(e.row.thick ? e.row.thick : "-"), 1)]), _: 1 }), t(o, { key: "material", prop: "material", sortable: "custom", "show-overflow-tooltip": true, label: "材质", align: "left", "min-width": "80px" }, { default: a((e) => [n(l(e.row.material ? e.row.material : "-"), 1)]), _: 1 }), t(o, { key: "netWeight", prop: "netWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单净重
(kg)`, align: "left", "min-width": "80px" }, { default: a((e) => [n(l(e.row.netWeight ? e.row.netWeight : "-"), 1)]), _: 1 }), t(o, { key: "grossWeight", prop: "grossWeight", sortable: "custom", "show-overflow-tooltip": true, label: `单毛重
(kg)`, align: "left", "min-width": "80px" }, { default: a((e) => [n(l(e.row.grossWeight ? e.row.grossWeight : "-"), 1)]), _: 1 }), t(o, { key: "surfaceArea", prop: "surfaceArea", sortable: "custom", label: `单面积
(㎡)`, align: "left", "min-width": "80px" }, { default: a((e) => [n(l(e.row.surfaceArea ? e.row.surfaceArea : "-"), 1)]), _: 1 }), t(o, { key: "picturePath", prop: "picturePath", label: "图片", align: "left", "min-width": "80px" }, { default: a((e) => [r("div", j, [t(H, { src: e.row.picturePath, onError: (u) => e.row.imgLoad = false }, { error: a(() => [r("div", L, [e.row.picturePath ? (p(), w("span", T, "加载失败")) : (p(), w("span", $, "未导入DXF"))])]), _: 2 }, 1032, ["src", "onError"])])]), _: 1 }), t(o, { prop: "usedQuantity", label: "数量", align: "left", width: "120px", fixed: "right" }, { default: a(({ row: e }) => [t(W, { modelValue: e.usedQuantity, "onUpdate:modelValue": (u) => e.usedQuantity = u, step: 1, min: 1, max: 99999999, size: "default", style: { width: "100%" }, "controls-position": "right" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), t(o, { label: "操作", width: "70", align: "center", fixed: "right" }, { default: a((e) => [t(C, { type: "danger", icon: "el-icon-delete", size: "default", onClick: A((u) => B(e.row.id), ["stop"]) }, null, 8, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, X = M(F, [["__scopeId", "data-v-6d3350d0"]]);
export {
  X as default
};
