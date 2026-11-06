import { ref as r } from "vue";
import { watch as y } from "vue";
import { computed as z } from "vue";
import { resolveComponent as R } from "vue";
import { openBlock as P } from "vue";
import { createBlock as $ } from "vue";
import { withCtx as m } from "vue";
import { createVNode as i } from "vue";
import { createElementVNode as q } from "vue";
import { ElFormItem as A } from "element-plus";
import { ElTree as G } from "element-plus";
import { ElForm as H } from "element-plus";
import { l as g, _ as Q, ds as W, i as X } from "../../../../shared/runtime.js";
function Y() {
  return g({ module: "contract", url: "deploy/project/template", method: "get" });
}
function Z(u) {
  return g({ module: "contract", url: "deploy/project/template/details", method: "get", params: u });
}
const ee = { class: "user-tree tree-container" }, te = { __name: "project-members", props: { formData: { type: Object, default: () => {
} }, isEdit: { type: Boolean, default: false } }, emits: ["getUserIds"], setup(u, { expose: k, emit: x }) {
  const U = u, D = x, { userDeptTree: s } = W(), p = r(), o = r(), N = r(false), w = { children: "children", label: "label" }, v = r([]), _ = r([]), n = r([]), c = r(), d = r([]), C = r({}), T = r({});
  y(s, (e) => {
    X(s.value) && B();
  }, { immediate: true, deep: true }), y(() => U.formData, (e) => {
    V(e);
  }, { deep: true, immediate: true });
  const O = z(() => N.value ? _.value : v.value);
  function j(e, t) {
    return e ? t.label.indexOf(e) !== -1 || t.parentLabel && t.parentLabel.indexOf(e) !== -1 : true;
  }
  function B() {
    let e = [], t = [];
    e = JSON.parse(JSON.stringify(s.value)), f(e, true), t = JSON.parse(JSON.stringify(s.value)), f(t, false), v.value = e, _.value = t;
  }
  function f(e, t, a) {
    e.forEach((l) => {
      l.disabled = t, l.parentLabel = a, l.isUser || (l.id === 1 ? l.label = "<公司>" + l.label : l.label = "<部门>" + l.label, l.id = -l.id), l.children && f(l.children, t, l.label);
    });
  }
  function E() {
    o.value?.setCheckedKeys(n.value);
  }
  function I(e) {
    h(e);
  }
  async function h(e) {
    let t = [];
    try {
      const { content: a = [] } = await Z({ id: e });
      t = a.map((l) => l.id);
    } catch (a) {
      console.log(a);
    } finally {
      n.value = t, D("getUserIds", t), E();
    }
  }
  const b = r([]);
  function L() {
    b.value = U.isEdit && c.value == null ? [] : n.value;
  }
  S();
  async function S() {
    let e = [];
    try {
      const { content: t = [] } = await Y();
      e = t.filter((a) => a.status === 1), e.forEach((a) => {
        !U.isEdit && a.isDefault === true && (c.value = a.id, h(a.id));
      });
    } catch (t) {
      console.log(t);
    } finally {
      d.value = e;
    }
  }
  function V(e) {
    c.value = void 0;
    n.value = U.isEdit && Array.isArray(e) ? e : [];
    E();
  }
  async function F() {
    try {
      return await p.value.validate();
    } catch (e) {
      return console.log("error", e), false;
    }
  }
  return k({ validateForm: F, getCheckUser: L, checkUser: b }), (e, t) => {
    const a = R("common-select-v2"), l = A, J = G, K = H;
    return P(), $(K, { ref_key: "memberRef", ref: p, model: T.value, rules: C.value, class: "from-text", size: "default", "label-position": "right", "label-width": "110px" }, { default: m(() => [i(l, { label: "成员模板" }, { default: m(() => [i(a, { modelValue: c.value, "onUpdate:modelValue": t[0] || (t[0] = (M) => c.value = M), options: d.value, disabled: d.value.isDefault, dataStructure: { key: "id", label: "templateName", value: "id" }, type: "other", placeholder: "成员模板", class: "input-underline", style: { width: "200px" }, onChange: I }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), i(l, null, { default: m(() => [q("div", ee, [i(J, { ref_key: "tree", ref: o, class: "filter-tree", data: O.value, "empty-text": "没有用户", props: w, "default-expand-all": "", "show-checkbox": "", "node-key": "id", "filter-node-method": j, "default-checked-keys": n.value }, null, 8, ["data", "default-checked-keys"])])]), _: 1 })]), _: 1 }, 8, ["model", "rules"]);
  };
} }, se = Q(te, [["__scopeId", "data-v-922e44d5"]]);
export {
  se as default
};
