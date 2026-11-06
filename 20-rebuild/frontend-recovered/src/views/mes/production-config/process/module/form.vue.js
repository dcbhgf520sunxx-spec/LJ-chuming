import { computed as S } from "vue";
import { ref as x } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as f } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as P } from "vue";
import { createElementVNode as C } from "vue";
import { withDirectives as G } from "vue";
import { createCommentVNode as V } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElForm as Y } from "element-plus";
import { _ as j, dM as c, cf as p, o as J, ao as Q, a as X, aw as Z } from "../../../../../shared/runtime.js";
import { u as ee } from "../../../../../modules/use-table-operate-4f84437f.js";
const te = { class: "process-main-content" }, oe = { __name: "form", setup(le) {
  const v = { productType: c.ARTIFACT.V, list: [] }, E = { name: void 0 }, R = S(() => o.productType & c.ARTIFACT.V ? [p.ASSEMBLY_RIVETING_WELDING, p.PAINT] : o.productType & c.ASSEMBLE.V ? [p.ASSEMBLY_RIVETING_WELDING] : o.productType & c.MACHINE_PART.V ? [p.DRILL_HOLE, p.MAKINGS] : p.ENUM), b = { name: [{ required: true, message: "请输入工序", trigger: "blur" }], type: [{ required: true, message: "请选择类型", trigger: "change" }] }, g = x(), w = x(), { maxHeight: k } = J({ extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body", ".process-main-content"], navbar: false, extraHeight: 70, minHeight: 300 }, () => g.value.loaded), { CRUD: T, crud: u, form: o } = Q(v, w), { init: A, addRow: I, removeRow: M } = ee(E, 10);
  T.HOOK.afterToAdd = () => {
    A(o.list);
  };
  const { tableValidate: N, cleanUpData: U, wrongCellMask: B } = Z({ rules: b });
  T.HOOK.beforeValidateCU = () => {
    const { validResult: s, dealList: n } = N(o.list);
    if (s) o.list = n;
    else return s;
  };
  function h(s, n, l) {
    const { $index: r } = s;
    if (n === "up") {
      if (r === 0) return;
      const d = l[r - 1];
      l.splice(r - 1, 1), l.splice(r, 0, d);
    } else {
      if (r === l.length - 1) return;
      const d = l[r + 1];
      l.splice(r + 1, 1), l.splice(r, 0, d);
    }
  }
  return u.submitFormFormat = (s) => (U(s.list), s.list = s.list.map((n, l) => (n.sort = l + 1, n)), s), (s, n) => {
    const l = y("common-button"), r = q, d = K, H = W, L = y("common-select"), z = y("common-table"), D = Y, F = y("common-drawer"), $ = O("parse-enum");
    return _(), f(F, { ref_key: "drawerRef", ref: g, visible: e(u).status.cu > 0, "before-close": e(u).cancelCU, title: e(u).status.title, "show-close": true, size: 700 }, { titleRight: i(() => [a(l, { size: "default", type: "success", icon: "el-icon-plus", onClick: n[0] || (n[0] = (t) => e(I)(e(o).list)) }), a(l, { loading: e(u).status.cu === 2, size: "default", type: "primary", onClick: e(u).submitCU }, { default: i(() => n[1] || (n[1] = [P("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: i(() => [C("div", te, [a(D, { ref_key: "formRef", ref: w, model: e(o), size: "default", "label-width": "80px" }, { default: i(() => [a(r, { label: "工序类型", prop: "productType" }, { default: i(() => [G(C("span", null, null, 512), [[$, { e: e(c), v: e(o).productType }]])]), _: 1 }), a(z, { border: "", data: e(o).list, "show-empty-symbol": false, "return-source-data": "", "cell-class-name": (t) => e(B)(t, b), "max-height": e(k), "row-key": "uid" }, { default: i(() => [a(d, { label: "序号", type: "index", align: "center", width: "60" }), a(d, { prop: "name", label: "工序", align: "center", "min-width": "180" }, { default: i(({ row: t }) => [a(H, { modelValue: t.name, "onUpdate:modelValue": (m) => t.name = m, modelModifiers: { trim: true }, readonly: t.boolUsed, type: "text", placeholder: "工序", size: "default", maxlength: "20", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "readonly"])]), _: 1 }), a(d, { prop: "type", label: "类型", align: "center", "min-width": "180" }, { default: i(({ row: t }) => [a(L, { modelValue: t.type, "onUpdate:modelValue": (m) => t.type = m, class: "input-underline", options: R.value, type: "enum", placeholder: "类型", style: { width: "100%" }, disabled: t.id }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "disabled"])]), _: 1 }), a(d, { label: "操作", align: "center", width: "110" }, { default: i((t) => [t.row.boolUsed ? V("", true) : (_(), f(l, { key: 0, icon: "el-icon-top", type: "primary", style: { padding: "5px" }, size: "default", disabled: t.$index === 0 || !!(t.row.name === "下料" && e(o).productType & e(c).MACHINE_PART.V), onClick: (m) => h(t, "up", e(o).list) }, null, 8, ["disabled", "onClick"])), t.row.boolUsed ? V("", true) : (_(), f(l, { key: 1, icon: "el-icon-bottom", type: "primary", style: { padding: "5px" }, size: "default", disabled: t.$index === e(o).list.length - 1 || !!(t.row.name === "下料" && e(o).productType & e(c).MACHINE_PART.V), onClick: (m) => h(t, "down", e(o).list) }, null, 8, ["disabled", "onClick"])), t.row.boolUsed ? (_(), f(X, { key: 3, class: "icon icon-readonly", "icon-class": "readonly" })) : (_(), f(l, { key: 2, icon: "el-icon-minus", type: "danger", style: { padding: "5px" }, size: "default", disabled: !!(t.row.name === "下料" && e(o).productType & e(c).MACHINE_PART.V), onClick: (m) => e(M)(e(o).list, t.$index) }, null, 8, ["disabled", "onClick"]))]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} }, re = j(oe, [["__scopeId", "data-v-7c23703a"]]);
export {
  re as default
};
