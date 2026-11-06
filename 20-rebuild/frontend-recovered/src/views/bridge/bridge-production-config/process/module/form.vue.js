import { computed as $ } from "vue";
import { ref as C } from "vue";
import { resolveComponent as y } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as _ } from "vue";
import { createBlock as f } from "vue";
import { withCtx as i } from "vue";
import { createVNode as a } from "vue";
import { unref as e } from "vue";
import { createTextVNode as G } from "vue";
import { createElementVNode as V } from "vue";
import { withDirectives as S } from "vue";
import { createCommentVNode as T } from "vue";
import { ElFormItem as q } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElInput as W } from "element-plus";
import { ElForm as X } from "element-plus";
import { _ as Y, aD as c, aH as p, o as j, ao as J, a as Q, aw as Z } from "../../../../../shared/runtime.js";
import { u as ee } from "../../../../../modules/use-table-operate-4f84437f.js";
const te = { class: "process-main-content" }, oe = { __name: "form", setup(le) {
  const v = { productType: c.BOX.V, list: [] }, E = { name: void 0 }, k = $(() => o.productType & c.BOX.V ? [p.ASSEMBLY_RIVETING_WELDING, p.PAINT] : o.productType & c.CELL.V ? [p.ASSEMBLY_RIVETING_WELDING] : o.productType & c.MACHINE_PART.V ? [p.DRILL_HOLE, p.MAKINGS] : p.ENUM), b = { name: [{ required: true, message: "请输入工序", trigger: "blur" }], type: [{ required: true, message: "请选择类型", trigger: "change" }] }, g = C(), w = C(), { maxHeight: R } = j({ extraBox: ".el-drawer__header", wrapperBox: [".el-drawer__body", ".process-main-content"], navbar: false, extraHeight: 70, minHeight: 300 }, () => g.value.loaded), { CRUD: h, crud: u, form: o } = J(v, w), { init: I, addRow: N, removeRow: U } = ee(E, 10);
  h.HOOK.afterToAdd = () => {
    I(o.list);
  };
  const { tableValidate: B, cleanUpData: A, wrongCellMask: H } = Z({ rules: b });
  h.HOOK.beforeValidateCU = () => {
    const { validResult: s, dealList: n } = B(o.list);
    if (s) o.list = n;
    else return s;
  };
  function x(s, n, l) {
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
  return u.submitFormFormat = (s) => (A(s.list), s.list = s.list.map((n, l) => (n.sort = l + 1, n)), s), (s, n) => {
    const l = y("common-button"), r = q, d = K, M = W, D = y("common-select"), L = y("common-table"), z = X, O = y("common-drawer"), P = F("parse-enum");
    return _(), f(O, { ref_key: "drawerRef", ref: g, visible: e(u).status.cu > 0, "before-close": e(u).cancelCU, title: e(u).status.title, "show-close": true, size: 700 }, { titleRight: i(() => [a(l, { size: "default", type: "success", icon: "el-icon-plus", onClick: n[0] || (n[0] = (t) => e(N)(e(o).list)) }), a(l, { loading: e(u).status.cu === 2, size: "default", type: "primary", onClick: e(u).submitCU }, { default: i(() => n[1] || (n[1] = [G("确认")])), _: 1, __: [1] }, 8, ["loading", "onClick"])]), content: i(() => [V("div", te, [a(z, { ref_key: "formRef", ref: w, model: e(o), size: "default", "label-width": "80px" }, { default: i(() => [a(r, { label: "工序类型", prop: "productType" }, { default: i(() => [S(V("span", null, null, 512), [[P, { e: e(c), v: e(o).productType }]])]), _: 1 }), a(L, { border: "", data: e(o).list, "show-empty-symbol": false, "return-source-data": "", "cell-class-name": (t) => e(H)(t, b), "max-height": e(R), "row-key": "uid" }, { default: i(() => [a(d, { label: "序号", type: "index", align: "center", width: "60" }), a(d, { prop: "name", label: "工序", align: "center", "min-width": "180" }, { default: i(({ row: t }) => [a(M, { modelValue: t.name, "onUpdate:modelValue": (m) => t.name = m, modelModifiers: { trim: true }, readonly: t.boolUsed, type: "text", placeholder: "工序", size: "default", maxlength: "20", class: "input-underline", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "readonly"])]), _: 1 }), a(d, { prop: "type", label: "类型", align: "center", "min-width": "180" }, { default: i(({ row: t }) => [a(D, { modelValue: t.type, "onUpdate:modelValue": (m) => t.type = m, class: "input-underline", options: k.value, type: "enum", placeholder: "类型", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 }), a(d, { label: "操作", align: "center", width: "110" }, { default: i((t) => [t.row.boolUsed ? T("", true) : (_(), f(l, { key: 0, icon: "el-icon-top", type: "primary", style: { padding: "5px" }, size: "default", disabled: t.$index === 0 || !!(t.row.name === "下料" && e(o).productType & e(c).MACHINE_PART.V), onClick: (m) => x(t, "up", e(o).list) }, null, 8, ["disabled", "onClick"])), t.row.boolUsed ? T("", true) : (_(), f(l, { key: 1, icon: "el-icon-bottom", type: "primary", style: { padding: "5px" }, size: "default", disabled: t.$index === e(o).list.length - 1 || !!(t.row.name === "下料" && e(o).productType & e(c).MACHINE_PART.V), onClick: (m) => x(t, "down", e(o).list) }, null, 8, ["disabled", "onClick"])), t.row.boolUsed ? (_(), f(Q, { key: 3, class: "icon icon-readonly", "icon-class": "readonly" })) : (_(), f(l, { key: 2, icon: "el-icon-minus", type: "danger", style: { padding: "5px" }, size: "default", disabled: !!(t.row.name === "下料" && e(o).productType & e(c).MACHINE_PART.V), onClick: (m) => e(U)(e(o).list, t.$index) }, null, 8, ["disabled", "onClick"]))]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} }, re = Y(oe, [["__scopeId", "data-v-433b0fe0"]]);
export {
  re as default
};
