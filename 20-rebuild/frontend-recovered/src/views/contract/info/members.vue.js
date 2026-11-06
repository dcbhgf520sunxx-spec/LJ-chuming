import { ref as s } from "vue";
import { watch as p } from "vue";
import { computed as T } from "vue";
import { openBlock as I } from "vue";
import { createElementBlock as O } from "vue";
import { createElementVNode as c } from "vue";
import { createVNode as b } from "vue";
import { ElInput as S } from "element-plus";
import { ElTree as j } from "element-plus";
import { _ as w, ds as V, i as E, jB as J } from "../../../shared/runtime.js";
const M = { class: "header-container" }, C = { class: "filter-container" }, K = { class: "filter-left-box" }, P = ["loading"], A = { __name: "members", props: { projectId: { type: [Number, String], default: void 0 }, isModify: { type: Boolean, default: false } }, setup(y, { expose: k }) {
  const n = y, { userDeptTree: i } = V(), o = s(), d = s(), x = { children: "children", label: "label" }, m = s([]), _ = s([]), a = s([]), g = s(false), v = s([]);
  p(() => d.value, (e) => {
    o.value.filter(e);
  }), p(() => n.projectId, (e) => {
    e ? f() : (a.value = [], h());
  }, { deep: true, immediate: true }), p(i, (e) => {
    E(i.value) && (B(), f());
  }, { immediate: true, deep: true });
  const N = T(() => n.isModify ? _.value : m.value);
  function U(e, t) {
    return e ? t.label.indexOf(e) !== -1 || t.parentLabel && t.parentLabel.indexOf(e) !== -1 : true;
  }
  function B() {
    let e = [], t = [];
    e = JSON.parse(JSON.stringify(i.value)), u(e, true), t = JSON.parse(JSON.stringify(i.value)), u(t, false), m.value = e, _.value = t;
  }
  function u(e, t, r) {
    e.forEach((l) => {
      l.disabled = t, l.parentLabel = r, l.isUser || (l.id === 1 ? l.label = "<公司>" + l.label : l.label = "<部门>" + l.label, l.id = -l.id), l.children && u(l.children, t, l.label);
    });
  }
  async function f() {
    let e = [];
    try {
      const { content: t } = await J(n.projectId);
      e = t.map((r) => r.id);
    } catch (t) {
      console.log(t);
    } finally {
      v.value = e, a.value = e, h();
    }
  }
  function D() {
    let e = o.value.getCheckedKeys(true);
    e = e.filter((t) => t > 0), a.value = e;
  }
  function h() {
    o.value.setCheckedKeys(a.value);
  }
  return k({ getUser: D, checkedList: a, fetchMembers: f, originUserList: v }), (e, t) => {
    const r = S, l = j;
    return I(), O("div", null, [c("div", M, [c("div", C, [c("div", K, [b(r, { modelValue: d.value, "onUpdate:modelValue": t[0] || (t[0] = (L) => d.value = L), modelModifiers: { trim: true }, class: "filter-item", placeholder: "输入关键字进行过滤", style: { width: "270px" } }, null, 8, ["modelValue"])])])]), c("div", { class: "user-tree tree-container", loading: g.value }, [b(l, { ref_key: "tree", ref: o, class: "filter-tree", data: N.value, "empty-text": "没有用户", props: x, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": U, "default-checked-keys": a.value }, null, 8, ["data", "default-checked-keys"])], 8, P)]);
  };
} }, F = w(A, [["__scopeId", "data-v-1e40a1a3"]]);
export {
  F as default
};
