import { ref as q } from "vue";
import { inject as J } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as i } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as o } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as A } from "vue";
import { createCommentVNode as y } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as E } from "vue";
import { withModifiers as w } from "vue";
import { createElementBlock as D } from "vue";
import { Fragment as H } from "vue";
import { renderList as K } from "vue";
import { ElTag as M } from "element-plus";
import { ElFormItem as $ } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElInputNumber as Q } from "element-plus";
import { ElDatePicker as W } from "element-plus";
import { Delete as X } from "@element-plus/icons-vue";
import { ElIcon as Z } from "element-plus";
import { ElForm as ee } from "element-plus";
import { _ as te, ao as le, dj as u, i as b } from "../../../../../../shared/runtime.js";
const oe = ["onClick"], ae = { __name: "form", props: { line: { type: Object, default: () => {
} } }, setup(m) {
  const x = q(), S = { id: void 0, fieldValue: void 0, fieldSort: void 0 }, { crud: r, CRUD: L, form: l } = le(S, x), I = J("firstLevelDeptOptions"), V = m, U = { fieldValue: [{ required: true, message: "请输入名称" }], fieldSort: [{ required: true, message: "请输入排序", trigger: "blur", type: "number" }] }, N = (d, t) => {
    d.splice(t, 1);
  };
  function z() {
    b(l.yearTarget) ? l.yearTarget.push({}) : l.yearTarget = [{}];
  }
  return L.HOOK.beforeSubmit = async () => {
    var d, t, p;
    (((d = V.line) == null ? void 0 : d.V) === u.FIRST_LEVEL_DEPT.V || ((t = V.line) == null ? void 0 : t.V) === u.SECOND_LEVEL_DEPT.V) && (r.form.deptJson = {}, (p = r.form.yearTarget) == null || p.forEach((s) => {
      s.year && s.weight && (r.form.deptJson[s.year] = s.weight);
    }));
  }, (d, t) => {
    const p = M, s = g("common-button"), F = g("common-select"), c = $, O = G, C = Q, Y = W, R = X, B = Z, P = ee, j = g("common-dialog");
    return i(), _(j, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(r).cancelCU, visible: e(r).status.cu > 0, title: e(r).status.title, width: "580px" }, { titleAfter: o(() => [e(b)(V.line) ? (i(), _(p, { key: 0 }, { default: o(() => [v(A(m.line.L), 1)]), _: 1 })) : y("", true)]), titleRight: o(() => [a(s, { loading: e(r).status.cu === 2, type: "primary", size: "default", onClick: e(r).submitCU }, { default: o(() => t[3] || (t[3] = [v("确认")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: o(() => [a(P, { ref_key: "formRef", ref: x, model: e(l), rules: U, size: "default", "label-width": "190px" }, { default: o(() => {
      var T, k;
      return [e(l).fieldEnumType === e(u).SECOND_LEVEL_DEPT.V ? (i(), _(c, { key: 0, label: "所属一级部门", prop: "parentId" }, { default: o(() => [a(F, { modelValue: e(l).parentId, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(l).parentId = n), options: e(I), dataStructure: { key: "id", label: "fieldValue", value: "id" }, clearable: "", class: "filter-item", placeholder: "请选择一级部门", style: { width: "220px" } }, null, 8, ["modelValue", "options"])]), _: 1 })) : y("", true), a(c, { label: "名称", prop: "fieldValue" }, { default: o(() => [a(O, { modelValue: e(l).fieldValue, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(l).fieldValue = n), placeholder: "输入名称", class: "filter-item", style: { width: "220px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), a(c, { label: "排序", prop: "fieldSort" }, { default: o(() => [a(C, { class: "align-left", modelValue: e(l).fieldSort, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(l).fieldSort = n), placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "200px" }, min: 0, max: 1e3 }, null, 8, ["modelValue"])]), _: 1 }), ((T = m.line) == null ? void 0 : T.V) === e(u).FIRST_LEVEL_DEPT.V || ((k = m.line) == null ? void 0 : k.V) === e(u).SECOND_LEVEL_DEPT.V ? (i(), _(c, { key: 1, label: "目标任务（万元）", prop: "fieldSort" }, { label: o(() => [t[4] || (t[4] = E("span", null, "目标任务（万元）", -1)), a(s, { type: "warning", icon: "el-icon-plus", size: "default", onClick: w(z, ["stop"]) })]), default: o(() => [e(b)(e(l).yearTarget) ? (i(true), D(H, { key: 0 }, K(e(l).yearTarget, (n, h) => (i(), D("div", { style: { display: "flex" }, key: h }, [a(Y, { modelValue: n.year, "onUpdate:modelValue": (f) => n.year = f, type: "year", size: "default", style: { width: "150px !important" }, format: "YYYY", clearable: true, "value-format": "YYYY", placeholder: "选择年" }, null, 8, ["modelValue", "onUpdate:modelValue"]), E("div", null, [a(C, { modelValue: n.weight, "onUpdate:modelValue": (f) => n.weight = f, placeholder: "目标任务（万元）", type: "text", size: "default", "controls-position": "right", style: { width: "150px", margin: "0 3px" }, min: 0, max: 9999999999 }, null, 8, ["modelValue", "onUpdate:modelValue"])]), E("div", { onClick: w((f) => N(e(l).yearTarget, h), ["stop"]) }, [a(B, { style: { color: "#f56c6c", "font-size": "16px", "margin-top": "5px" } }, { default: o(() => [a(R)]), _: 1 })], 8, oe)]))), 128)) : y("", true)]), _: 1 })) : y("", true)];
    }), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, se = te(ae, [["__scopeId", "data-v-63a962d3"]]);
export {
  se as default
};
