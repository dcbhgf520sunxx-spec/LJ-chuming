import { ref as i } from "vue";
import { watch as y } from "vue";
import { computed as O } from "vue";
import { openBlock as h } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as s } from "vue";
import { unref as S } from "vue";
import { Fragment as C } from "vue";
import { createTextVNode as v } from "vue";
import { toDisplayString as _ } from "vue";
import { createCommentVNode as I } from "vue";
import { createVNode as T } from "vue";
import { ElTree as j } from "element-plus";
import { _ as B, ds as V, i as J } from "../../../../shared/runtime.js";
import { j as w } from "../../../../modules/judgeSameValue-9683bdce.js";
const E = ["loading"], z = { style: { "font-size": "13px", color: "#666" } }, M = { style: { "font-size": "13px", color: "red" } }, A = { __name: "members", props: { projectId: { type: [Number, String], default: void 0 }, isModify: { type: Boolean, default: false }, checkedList: { type: Array, default: () => [] }, detail: { type: Object, default: () => {
} }, originContractInfo: { type: Object, default: () => {
} } }, setup(r) {
  const n = r, { userDeptTree: l } = V(), c = i(), g = { children: "children", label: "label" }, u = i([]), f = i([]), N = i(false);
  y(() => n.checkedList, (a) => {
    a.length > 0 && L();
  }, { deep: true, immediate: true }), y(l, (a) => {
    J(l.value) && D();
  }, { immediate: true, deep: true });
  const x = O(() => n.isModify ? f.value : u.value);
  function U(a, t) {
    return a ? t.label.indexOf(a) !== -1 || t.parentLabel && t.parentLabel.indexOf(a) !== -1 : true;
  }
  function D() {
    let a = [], t = [];
    a = JSON.parse(JSON.stringify(l.value)), o(a, true), t = JSON.parse(JSON.stringify(l.value)), o(t, false), u.value = a, f.value = t;
  }
  function o(a, t, d) {
    a.forEach((e) => {
      e.disabled = t, e.parentLabel = d, e.isUser || (e.id === 1 ? e.label = "<公司>" + e.label : e.label = "<部门>" + e.label, e.id = -e.id), e.children && o(e.children, t, e.label);
    });
  }
  function L() {
    c.value.setCheckedKeys(n.checkedList);
  }
  return (a, t) => {
    var e, p, m, b;
    const d = j;
    return h(), k("div", null, [s("div", { class: "user-tree tree-container", loading: N.value }, [S(w)((e = r.originContractInfo) == null ? void 0 : e.relationUserId, (p = r.detail) == null ? void 0 : p.relationUserId) ? I("", true) : (h(), k(C, { key: 0 }, [s("div", z, [t[0] || (t[0] = v("修改前：")), s("span", null, _((m = r.originContractInfo) == null ? void 0 : m.relationUserName), 1)]), s("div", M, [t[1] || (t[1] = v("修改后：")), s("span", null, _((b = r.detail) == null ? void 0 : b.relationUserName), 1)])], 64)), T(d, { ref_key: "tree", ref: c, class: "filter-tree", data: x.value, "empty-text": "没有用户", props: g, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": U, "default-checked-keys": r.checkedList }, null, 8, ["data", "default-checked-keys"])], 8, E)]);
  };
} }, q = B(A, [["__scopeId", "data-v-62a30a46"]]);
export {
  q as default
};
