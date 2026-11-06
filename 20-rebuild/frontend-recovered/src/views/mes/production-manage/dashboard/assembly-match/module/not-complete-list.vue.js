import { ref as n } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as B } from "vue";
import { createBlock as H } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as e } from "vue";
import { unref as l } from "vue";
import { createTextVNode as N } from "vue";
import { toDisplayString as u } from "vue";
import { normalizeStyle as R } from "vue";
import { isRef as T } from "vue";
import { ElTableColumn as q } from "element-plus";
import { ElTag as E } from "element-plus";
import { u as L, o as Q, a3 as d } from "../../../../../../shared/runtime.js";
const z = { class: "print-wrap" }, D = { __name: "not-complete-list", props: { visible: { type: Boolean, default: false } }, emits: ["update:visible"], setup(f, { emit: w }) {
  const s = n(), y = w, _ = f, { visible: r, handleClose: b } = L({ emit: y, props: _, field: "visible" }), { maxHeight: g } = Q({ extraBox: [".el-drawer__header", ".nameViews"], extraHeight: 10, wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, s), h = n(false), v = n([]);
  return (p, m) => {
    const k = i("print-table"), t = q, x = E, V = i("common-table"), C = i("common-drawer");
    return B(), H(C, { ref_key: "drawerRef", ref: s, title: "未齐套清单", modelValue: l(r), "onUpdate:modelValue": m[0] || (m[0] = (o) => T(r) ? r.value = o : null), contentLoading: h.value, direction: "rtl", "before-close": l(b), size: "70%" }, { titleRight: a(() => [c("div", z, [e(k, { "api-key": p.apiKey, params: { ...p.query }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])])]), content: a(() => [e(V, { data: v.value, "max-height": l(g), style: { width: "100%", "margin-top": "10px" } }, { default: a(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { label: "属性", prop: "type", align: "center" }, { default: a(({ row: o }) => [e(x, { type: o.type === l(d).MACHINE_PART.V ? "warning" : "success" }, { default: a(() => [N(u(l(d).VL[o.type]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), e(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号" }), e(t, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "140" }), e(t, { key: "length", prop: "length", "show-overflow-tooltip": true, label: "长度" }), e(t, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }), e(t, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量" }), e(t, { key: "netWeight", prop: "netWeight", "show-overflow-tooltip": true, label: "单重（kg）" }), e(t, { key: "completeQuantity", prop: "completeQuantity", "show-overflow-tooltip": true, label: "实际生产数" }, { default: a((o) => [c("span", { style: R(o.row.completeQuantity === o.row.quantity ? "color: green" : "color: red") }, u(o.row.completeQuantity), 5)]), _: 1 }), e(t, { key: "groups.name", prop: "groups.name", "show-overflow-tooltip": true, label: "负责班组" })]), _: 1 }, 8, ["data", "max-height"])]), _: 1 }, 8, ["modelValue", "contentLoading", "before-close"]);
  };
} };
export {
  D as default
};
