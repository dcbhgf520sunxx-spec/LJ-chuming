import { ref as s } from "vue";
import { watch as j } from "vue";
import { nextTick as J } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as u } from "vue";
import { createBlock as d } from "vue";
import { withCtx as o } from "vue";
import { createVNode as m } from "vue";
import { unref as r } from "vue";
import { createTextVNode as v } from "vue";
import { withModifiers as K } from "vue";
import { createElementVNode as w } from "vue";
import { toDisplayString as L } from "vue";
import { createElementBlock as q } from "vue";
import { Fragment as P } from "vue";
import { renderList as $ } from "vue";
import { withKeys as G } from "vue";
import { isRef as H } from "vue";
import { ElMessage as f } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElTag as X } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElForm as Z } from "element-plus";
import { _ as ee, u as te, i as C, fd as g, f3 as ae, fc as oe } from "../../../../../../shared/runtime.js";
const le = { class: "tax-list flex-rsc" }, ne = { __name: "form", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(h, { emit: D }) {
  const y = h, e = s({}), O = {}, i = s(), E = s(), p = s(false), l = s(), _ = s(false), b = D, { visible: c, handleClose: N } = te({ emit: b, props: y });
  j(() => c.value, (n) => {
    n && (T(), S());
  }, { deep: true, immediate: true });
  function T() {
    i.value && i.value.resetFields(), e.value = JSON.parse(JSON.stringify(y.detailInfo)), i.value && J(() => {
      i.value.clearValidate();
    });
  }
  function S() {
    p.value = false, l.value = void 0;
  }
  function R(n) {
    if (e.value.productSectionNameList.splice(e.value.productSectionNameList.indexOf(n.name), 1), e.value.sectionWarehouseConfigDTOList.splice(e.value.sectionWarehouseConfigDTOList.findIndex((t) => t.name === n.name), 1), e.value.productSectionNameList.length === 0) {
      f.warning("至少保留一条数据");
      return;
    }
  }
  function B() {
    p.value = true;
  }
  function V() {
    if (e.value.productSectionNameList.includes(l.value)) {
      f.warning("当前名称已存在");
      return;
    }
    C(l.value) && (e.value.productSectionNameList.push(l.value), e.value.sectionWarehouseConfigDTOList.push({ name: l.value, source: g.USER_ADDITION.V })), S();
  }
  async function F() {
    try {
      if (ae(e.value.productSectionNameList, e.value.originProductSectionNameList)) return f.error("数据未改动"), false;
      _.value = true, await oe.edit(e.value), f.success("修改成功"), b("success"), N();
    } catch (n) {
      console.log("修改失败", n);
    } finally {
      _.value = false;
    }
  }
  return (n, t) => {
    const x = k("common-button"), I = Q, z = X, A = Y, U = Z, W = k("common-dialog");
    return u(), d(W, { "append-to-body": "", "close-on-click-modal": false, "before-close": r(N), modelValue: r(c), "onUpdate:modelValue": t[2] || (t[2] = (a) => H(c) ? c.value = a : null), title: "编辑", width: "600px" }, { titleRight: o(() => [m(x, { loading: _.value, size: "default", type: "primary", disabled: !r(C)(e.value.productSectionNameList), onClick: F }, { default: o(() => t[3] || (t[3] = [v(" 确认 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])]), default: o(() => [m(U, { ref_key: "formRef", ref: i, model: e.value, rules: O, size: "default", "label-width": "100px", class: "tax-setting", onSubmit: t[1] || (t[1] = K(() => {
    }, ["prevent"])) }, { default: o(() => [m(I, { label: "类型", prop: "typeName" }, { default: o(() => [w("div", null, L(e.value.typeName), 1)]), _: 1 }), m(I, { label: "名称", prop: "productSectionNameList" }, { default: o(() => [w("div", le, [(u(true), q(P, null, $(e.value.sectionWarehouseConfigDTOList, (a, M) => (u(), d(z, { size: "large", key: M, type: a.source === r(g).USER_ADDITION.V ? "warning" : "primary", closable: a.source === r(g).USER_ADDITION.V, "disable-transitions": false, onClose: (se) => R(a) }, { default: o(() => [v(L(a.name), 1)]), _: 2 }, 1032, ["type", "closable", "onClose"]))), 128)), p.value ? (u(), d(A, { key: 0, class: "input-new-tag", ref_key: "inputRef", ref: E, modelValue: l.value, "onUpdate:modelValue": t[0] || (t[0] = (a) => l.value = a), modelModifiers: { trim: true }, type: "text", placeholder: "名称", onKeyup: G(V, ["enter"]), onBlur: V, maxlength: "60" }, null, 8, ["modelValue"])) : (u(), d(x, { key: 1, class: "button-new-tag", icon: "el-icon-plus", size: "default", onClick: B }, { default: o(() => t[4] || (t[4] = [v("添加")])), _: 1, __: [4] }))])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "modelValue"]);
  };
} }, re = ee(ne, [["__scopeId", "data-v-14a1fd01"]]);
export {
  re as default
};
