import { ref as l } from "vue";
import { watch as v } from "vue";
import { computed as V } from "vue";
import { resolveComponent as J } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as o } from "vue";
import { createVNode as u } from "vue";
import { createBlock as z } from "vue";
import { withCtx as b } from "vue";
import { createTextVNode as k } from "vue";
import { ElMessage as M } from "element-plus";
import { ElInput as K } from "element-plus";
import { ElTree as P } from "element-plus";
import { _ as $, ds as q, i as A, jB as F, kk as G } from "../../../../shared/runtime.js";
const H = { class: "header-container" }, Q = { class: "filter-container" }, R = { class: "filter-left-box" }, W = { class: "filter-right-box", style: { display: "inline-block" } }, X = { key: 1, style: { display: "inline-block" } }, Y = ["loading"], Z = { __name: "index", props: { permission: { type: Object, required: true }, projectId: { type: [Number, String] }, refresh: { type: Boolean, default: false } }, emits: ["success"], setup(j, { emit: w }) {
  const B = w, d = j, { userDeptTree: n } = q(), c = l(), f = l(), a = l(false), p = l(false), C = { children: "children", label: "label" }, h = l([]), g = l([]), i = l([]), T = l(false);
  v(() => d.projectId, (t) => {
    t ? x() : (i.value = [], _());
  }, { deep: true, immediate: true }), v(n, (t) => {
    A(n.value) && (I(), x());
  }, { immediate: true, deep: true }), v(f, (t) => {
    c.value.filter(t);
  });
  const D = V(() => a.value ? g.value : h.value);
  function E(t, e) {
    return t ? e.label.indexOf(t) !== -1 || e.parentLabel && e.parentLabel.indexOf(t) !== -1 : true;
  }
  function I() {
    let t = [], e = [];
    t = JSON.parse(JSON.stringify(n.value)), m(t, true), e = JSON.parse(JSON.stringify(n.value)), m(e, false), h.value = t, g.value = e;
  }
  function m(t, e, r) {
    t.forEach((s) => {
      s.disabled = e, s.parentLabel = r, s.isUser || (s.id === 1 ? s.label = "<公司>" + s.label : s.label = "<部门>" + s.label, s.id = -s.id), s.children && m(s.children, e, s.label);
    });
  }
  async function x() {
    let t = [];
    try {
      const { content: e } = await F(d.projectId);
      t = e.map((r) => r.id);
    } catch (e) {
      console.log(e);
    } finally {
      i.value = t, _();
    }
  }
  function L() {
    a.value = false, _();
  }
  async function O() {
    try {
      p.value = true;
      let t = c.value.getCheckedKeys(true);
      t = t.filter((e) => e > 0), await G(d.projectId, { ids: t }), i.value = t, M({ message: "更新项目成员成功", type: "success" }), a.value = false, B("success");
    } catch (t) {
      console.log("提交用户", t);
    } finally {
      p.value = false;
    }
  }
  function _() {
    c.value.setCheckedKeys(i.value);
  }
  return (t, e) => {
    const r = K, s = J("common-button"), S = P;
    return y(), U("div", null, [o("div", H, [o("div", Q, [o("div", R, [u(r, { modelValue: f.value, "onUpdate:modelValue": e[0] || (e[0] = (N) => f.value = N), modelModifiers: { trim: true }, class: "filter-item", placeholder: "输入关键字进行过滤", style: { width: "270px" } }, null, 8, ["modelValue"])]), o("div", W, [a.value ? (y(), U("div", X, [u(s, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh", onClick: L }, { default: b(() => e[3] || (e[3] = [k("取消")])), _: 1, __: [3] }), u(s, { loading: p.value, class: "filter-item", size: "default", style: { "margin-left": "0px" }, type: "success", icon: "el-icon-circle-plus", onClick: O }, { default: b(() => e[4] || (e[4] = [k("保存")])), _: 1, __: [4] }, 8, ["loading"])])) : (y(), z(s, { key: 0, class: "filter-item", size: "default", type: "primary", icon: "el-icon-edit", onClick: e[1] || (e[1] = (N) => a.value = true) }, { default: b(() => e[2] || (e[2] = [k("修改")])), _: 1, __: [2] }))])])]), o("div", { class: "user-tree tree-container", loading: T.value }, [u(S, { ref_key: "tree", ref: c, class: "filter-tree", data: D.value, "empty-text": "没有用户", props: C, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": E, "default-checked-keys": i.value }, null, 8, ["data", "default-checked-keys"])], 8, Y)]);
  };
} }, le = $(Z, [["__scopeId", "data-v-e463b534"]]);
export {
  le as default
};
