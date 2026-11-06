import { ref as l } from "vue";
import { watch as u } from "vue";
import { computed as M } from "vue";
import { nextTick as j } from "vue";
import { resolveComponent as U } from "vue";
import { openBlock as w } from "vue";
import { createBlock as I } from "vue";
import { withCtx as b } from "vue";
import { withDirectives as q } from "vue";
import { createTextVNode as z } from "vue";
import { createCommentVNode as F } from "vue";
import { createElementVNode as n } from "vue";
import { createVNode as N } from "vue";
import { unref as T } from "vue";
import { isRef as P } from "vue";
import { ElMessage as $ } from "element-plus";
import { ElInput as A } from "element-plus";
import { ElTree as G } from "element-plus";
import { vLoading as H } from "element-plus";
import { a as Q, s as W } from "../../../modules/role-8519830b.js";
import { _ as X, ds as Y, u as Z, i as ee } from "../../../shared/runtime.js";
const te = { class: "header-container" }, se = { class: "filter-container" }, le = { class: "filter-left-box" }, ae = ["loading"], oe = { __name: "dept-user", props: { showType: { type: String, default: void 0 }, roleId: { type: [Number, String] }, refresh: { type: Boolean, default: false } }, emits: ["success", "update:modelValue"], setup(y, { emit: V }) {
  const a = y, { userDeptTree: d } = Y(), g = V, { visible: c, handleClose: D } = Z({ emit: g, props: a }), r = l(), f = l(), p = l(false), C = { children: "children", label: "label" }, k = l([]), x = l([]), o = l([]), L = l(false);
  u(() => a.roleId, (e) => {
    e ? v() : (o.value = [], _());
  }, { deep: true, immediate: true }), u(() => c, (e) => {
    e ? v() : (o.value = [], _());
  }, { deep: true, immediate: true }), u(d, (e) => {
    ee(d.value) && (S(), v());
  }, { immediate: true, deep: true }), u(f, (e) => {
    r.value.filter(e);
  });
  const B = M(() => a.showType === "detail" ? k.value : x.value);
  function O(e, t) {
    return e ? t.label.indexOf(e) !== -1 || t.parentLabel && t.parentLabel.indexOf(e) !== -1 : true;
  }
  function S() {
    let e = [], t = [];
    e = JSON.parse(JSON.stringify(d.value)), m(e, true), t = JSON.parse(JSON.stringify(d.value)), m(t, false), k.value = e, x.value = t;
  }
  function m(e, t, i) {
    e.forEach((s) => {
      s.disabled = t, s.parentLabel = i, s.isUser || (s.id === 1 ? s.label = "<公司>" + s.label : s.label = "<部门>" + s.label, s.id = -s.id), s.children && m(s.children, t, s.label);
    });
  }
  async function v() {
    let e = [];
    if (a.roleId) try {
      e = (await Q({ roleId: a.roleId }) || []).map((i) => i.id);
    } catch (t) {
      console.log(t);
    } finally {
      o.value = e, _();
    }
  }
  async function E() {
    try {
      p.value = true;
      let e = r.value.getCheckedKeys(true);
      e = e.filter((t) => t > 0), await W({ roleId: a.roleId, userIds: e }), o.value = e, $({ message: "人员设置成功", type: "success" }), g("success");
    } catch (e) {
      console.log("提交用户", e);
    } finally {
      p.value = false;
    }
  }
  function _() {
    r.value && j(() => {
      r.value.setCheckedKeys(o.value);
    });
  }
  return (e, t) => {
    const i = U("common-button"), s = A, J = G, R = U("common-dialog"), K = H;
    return w(), I(R, { "append-to-body": "", modelValue: T(c), "onUpdate:modelValue": t[1] || (t[1] = (h) => P(c) ? c.value = h : null), top: "10vh", width: "600px", "before-close": T(D), title: "人员配置", center: false, "close-on-click-modal": false }, { titleRight: b(() => [y.showType === "edit" ? q((w(), I(i, { key: 0, type: "primary", size: "default", onClick: E }, { default: b(() => t[2] || (t[2] = [z("提交")])), _: 1, __: [2] })), [[K, p.value]]) : F("", true)]), default: b(() => [n("div", null, [n("div", te, [n("div", se, [n("div", le, [N(s, { modelValue: f.value, "onUpdate:modelValue": t[0] || (t[0] = (h) => f.value = h), modelModifiers: { trim: true }, class: "filter-item", placeholder: "输入关键字进行过滤", style: { width: "270px" } }, null, 8, ["modelValue"])])])]), n("div", { class: "user-tree tree-container", loading: L.value }, [N(J, { ref_key: "tree", ref: r, class: "filter-tree", data: B.value, "empty-text": "没有用户", props: C, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": O, "default-checked-keys": o.value }, null, 8, ["data", "default-checked-keys"])], 8, ae)])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ce = X(oe, [["__scopeId", "data-v-b22c5928"]]);
export {
  ce as default
};
