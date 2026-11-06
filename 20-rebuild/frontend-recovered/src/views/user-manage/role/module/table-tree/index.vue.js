import { ref as f } from "vue";
import { provide as D } from "vue";
import { watch as O } from "vue";
import { nextTick as U } from "vue";
import ge from "lodash";
import { resolveComponent as se } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as u } from "vue";
import { createVNode as y } from "vue";
import { withCtx as h } from "vue";
import { createElementVNode as i } from "vue";
import { renderSlot as ne } from "vue";
import { unref as I } from "vue";
import { Fragment as T } from "vue";
import { renderList as V } from "vue";
import { createBlock as w } from "vue";
import { normalizeStyle as F } from "vue";
import { toDisplayString as C } from "vue";
import { createTextVNode as $ } from "vue";
import { withDirectives as oe } from "vue";
import { createCommentVNode as Ee } from "vue";
import { vShow as xe } from "vue";
import { ElCheckbox as Se } from "element-plus";
import { ElCard as Le } from "element-plus";
import { ElCollapseItem as Ne } from "element-plus";
import { ElCollapse as De } from "element-plus";
import { ElDivider as Ie } from "element-plus";
import { ElTree as Te } from "element-plus";
import { vLoading as Ve } from "element-plus";
import { _ as we, xb as Z, xd as g, i as P, b as de, a as Pe } from "../../../../../shared/runtime.js";
import Re from "./TableItem.vue.js";
import { u as Ae } from "../../../../../modules/use-dept-b8e95315.js";
const Ue = { class: "dialog-header" }, Me = { style: { display: "flex", "align-content": "center", "align-items": "center" } }, Be = { key: 0 }, Ke = { key: 1, style: { display: "flex" } }, Oe = ["label", "checked"], Fe = { class: "card-header", style: { "margin-bottom": "15px" } }, ze = { style: { "margin-bottom": "10px", "font-size": "14px", "font-weight": "bold" } }, He = { style: { float: "right" } }, $e = { class: "checkbox-container" }, je = { key: 0, style: { width: "100%", height: "1px", "border-top": "1px solid #8dabc3", "margin-top": "20px" } }, qe = { key: 1, class: "tip" }, Ye = { class: "card-header", style: { "margin-bottom": "15px" } }, Ze = { style: { "margin-bottom": "10px", "font-size": "14px", "font-weight": "bold" } }, Ge = { style: { float: "right" } }, Je = { class: "checkbox-container" }, Qe = ["label", "checked", "onClick"], We = { style: { padding: "40px 20px" } }, Xe = { style: { display: "flex", "align-items": "center" } }, el = { style: { display: "flex", padding: "40px" } }, ll = { style: { display: "flex", "flex-direction": "column" } }, tl = { style: { width: "100%", height: "260px", "margin-top": "20px", "overflow-y": "auto" } }, al = { key: 1, class: "tip" }, sl = { __name: "index", props: { systemList: { type: Array, default: () => [] }, currentSystem: { type: Object, default: () => {
} }, options: { type: Array, default: () => [] }, modelValue: { type: Array, default: () => [] }, checkStrictly: { type: Boolean, default: false }, checkable: { type: Boolean, default: false }, onlyShowChecked: { type: Boolean, default: false }, returnLeaf: { type: Boolean, default: true }, returnIndeterminate: { type: Boolean, default: false }, isDeleteNonexistent: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, loading: { type: Boolean, default: false }, dataStructure: { type: Object, default: () => ({ key: "id", label: "label", children: "children" }) }, menuType: { type: Number }, dataPermissionList: { type: Object, default: () => {
} } }, emits: ["update:modelValue", "change", "systemChange", "raidoChange", "checkListChange"], setup(L, { emit: ie }) {
  const R = f(null), { dept: G } = Ae(), E = ie, s = L, x = { CHECKED: 1, SEMI_CHECKED: 2, UN_CHECKED: 3, UN_SEMI_CHECKED: 4 }, p = f(), j = f(false), J = f(true), _ = f([]), S = f([]), Q = f([]), W = f([]), k = f(), N = f([]), X = f(), b = f([]), ee = f([]), A = f([]), M = f(1), q = f([]);
  D("checkedSet", k), D("checkStrictly", s.checkStrictly), D("returnLeaf", s.returnLeaf), D("returnIndeterminate", s.returnIndeterminate), D("disabled", s.disabled), D("checkable", s.checkable), D("onlyShowChecked", s.onlyShowChecked), O(() => s.options, (l) => {
    s.loading || U(() => {
      M.value += 1, b.value = Y(l);
    });
  }, { immediate: true, deep: true }), O(() => s.modelValue, (l) => {
    k.value = new Set(l);
  }, { immediate: true, deep: true }), O(k, () => {
    ce();
  }, { immediate: true, deep: true }), O(() => s.menuType, (l) => {
    l === Z.MENU_PICK.V ? U(() => {
      M.value += 1, b.value = Y(s.options);
    }) : U(async () => {
      var e, n, a, o;
      if (M.value += 1, ee.value = Y(s.options), A.value = (e = ee.value) == null ? void 0 : e.filter((d) => d.label === "CRM"), console.log(R.value, "treeRef"), s != null && s.dataPermissionList) for (const d in s == null ? void 0 : s.dataPermissionList) d === "isFullPermissions" && s.dataPermissionList[d] ? p.value = g.ALL_PERMISSION.V : d === "isThisDepartment" && s.dataPermissionList[d] ? p.value = g.CURRENT_DEPT_PERMISSION.V : d === "isThisDepartmentAndSubordinateDepartments" && s.dataPermissionList[d] ? p.value = g.CURRENT_DEPT_AND_UNDER_DEPT_PERMISSION.V : d === "isIndividual" && s.dataPermissionList[d] ? p.value = g.ONLY_CURRENT_USER.V : d === "departmentIds" && s.dataPermissionList[d] && ((n = s.dataPermissionList[d]) == null ? void 0 : n.length) > 0 ? p.value = g.CUSTOM_PERMISSION.V : d === "isIndividualAndThisDept" && s.dataPermissionList[d] && (p.value = g.DEPT_AND_PERSOANL.V);
      (a = A.value) == null || a.forEach((d) => {
        p.value ? d.checked = true : d.checked = false;
      }), W.value = s.systemList && ((o = s.systemList) == null ? void 0 : o.length) > 0 ? [s.systemList[0]] : [], Q.value = W.value.map((d) => ({ ...d, checked: !!p.value })), await z(false), await z(true);
    });
  }, { immediate: true, deep: true }), O(() => S.value, (l) => {
    p.value === g.CUSTOM_PERMISSION.V && U(() => {
      var e, n;
      _.value = (e = s.dataPermissionList) == null ? void 0 : e.departmentIds, (n = R.value) == null || n.setCheckedKeys(_.value);
    });
  }, { immediate: true, deep: true });
  const le = (l) => {
    l ? N.value = b.value.map((e) => e.key) : N.value = [];
  }, z = (l) => {
    l ? S.value = A.value.map((e) => e.key) : S.value = [];
  };
  function Y(l) {
    const e = ge.cloneDeep(k.value);
    q.value = [];
    const n = te(l, null, e, q.value);
    if (s.isDeleteNonexistent && e && e.forEach((a) => {
      k.value.delete(a);
    }), s.returnIndeterminate) {
      const a = [...s.modelValue, ...q.value];
      E("change", a), E("update:modelValue", a);
    }
    return n;
  }
  function te(l = [], e, n, a) {
    return l.map((o, d) => {
      var H;
      const K = (H = k.value) == null ? void 0 : H.has(o[s.dataStructure.key]);
      K && n.delete(o[s.dataStructure.key]);
      const m = { parent: e, key: o[s.dataStructure.key], label: o[s.dataStructure.label], checked: K, semiChecked: false, children: void 0, isSecondLevel: false, isFirstLevel: d };
      return P(o[s.dataStructure.children]) && (m.children = te(o.children, m, n, a), m.semiChecked = m.children.some((v) => v.semiChecked || v.checked), m.checked = m.children.every((v) => v.checked), m.children.every((v) => !P(v.children)) ? m.isSecondLevel = true : m.children.forEach((v) => {
        P(v.children) || (v.isSecondLevel = true);
      })), m.semiChecked && !m.checked && a && a.push(m.key), m;
    });
  }
  function ce() {
    const l = b.value, e = s.currentSystem, n = new Set(Array.from(k.value));
    (l == null ? void 0 : l.length) > 0 && (e.semiChecked = l.some((o) => o.semiChecked || o.checked), e.checked = l.every((o) => o.checked), e.checked || e.semiChecked ? n.add(e.id) : !e.checked && !e.semiChecked && n.delete(e.id));
    const a = Array.from(n);
    a.equals(s.modelValue) || (E("update:modelValue", a), E("change", a));
  }
  function re(l, e) {
    const n = e.target;
    if (n.classList.contains("el-checkbox__inner")) {
      l.checked = !l.checked, l.semiChecked = false, l.checked ? k.value.add(l.key) : k.value.delete(l.key);
      const a = l.checked ? x.CHECKED : x.UN_CHECKED;
      B(l, a);
    } else if (!n.classList.contains("el-checkbox__original")) {
      e.preventDefault(), N.value.indexOf(l.key) === -1 && (N.value = [...N.value, l.key]);
      const a = document.getElementsByClassName("table-tree")[0];
      console.log(a, "_parentElement1");
      const o = document.getElementById(`${l.key}`);
      console.log(o, o.offsetTop, l, "_childElement1"), a.scrollTo({ top: o.offsetTop, behavior: "smooth" });
    }
  }
  function ue(l, e) {
    e.preventDefault(), S.value.indexOf(l.key) === -1 && (S.value = [...S.value, l.key]), U(() => {
      const n = document.getElementsByClassName("table-tree")[0], a = document.getElementById(`${l.key}`);
      n.scrollTo({ top: a.offsetTop, behavior: "smooth" });
    });
  }
  const he = (l, e) => {
    var a;
    const n = e.target;
    n.classList.contains("el-checkbox__inner") && ((a = s.currentSystem) == null ? void 0 : a.id) === l.id ? (l.checked = !l.checked, l.checked ? (k.value.add(l.id), b.value.forEach((o) => {
      o.checked = true, o.semiChecked = false, k.value.add(o.key);
      const d = o.checked ? x.CHECKED : x.UN_CHECKED;
      B(o, d);
    })) : (k.value.delete(l.id), b.value.forEach((o) => {
      o.checked = false, o.semiChecked = false, k.value.delete(o.key);
      const d = o.checked ? x.CHECKED : x.UN_CHECKED;
      B(o, d);
    }))) : n.classList.contains("el-checkbox__original") || (e.preventDefault(), E("systemChange", l));
  };
  function B(l, e) {
    const n = l.children || [];
    e === x.CHECKED && n.forEach((a) => {
      const o = !s.returnLeaf || s.returnLeaf && de(a.children);
      a.semiChecked = true, a.checked = true, o && k.value.add(a.key), P(a.children) && B(a, e);
    }), e === x.UN_CHECKED && n.forEach((a) => {
      const o = !s.returnLeaf || s.returnLeaf && de(a.children);
      a.semiChecked = false, a.checked = false, o && k.value.delete(a.key), P(a.children) && B(a, e);
    });
  }
  function fe() {
    var e;
    const l = (n) => {
      n.forEach((a) => {
        a.expanded = j.value, a.children && a.children.length > 0 && l(a.children);
      });
    };
    l((e = R.value) == null ? void 0 : e.store._getAllNodes());
  }
  async function ke(l) {
    j.value = l, await fe();
  }
  function me(l) {
    p.value = l, E("raidoChange", p.value);
  }
  function ae(l = [], e = []) {
    for (const n of l) e.push(n.id), n.children && n.children.length && ae(n.children, e);
    return e;
  }
  function pe(l) {
    const e = [];
    if (_.value = [], l) {
      const n = ae(G.value, e);
      R.value.setCheckedKeys(n), _.value = n;
    } else R.value.setCheckedKeys([]), _.value = [];
    E("checkListChange", _.value);
  }
  function ye(l) {
    J.value = !l;
  }
  function ve(l, e) {
    _.value = [], _.value = e == null ? void 0 : e.checkedKeys, E("checkListChange", _.value);
  }
  function _e(l) {
    U(() => {
      R.value = l;
    });
  }
  return (l, e) => {
    const n = Se, a = Le, o = se("common-button"), d = Ne, K = De, m = se("common-radio"), H = Ie, v = Pe, be = Te, Ce = Ve;
    return c(), u("div", null, [y(a, { style: { "margin-bottom": "10px", height: "80px" }, shadow: "always" }, { default: h(() => [i("div", Ue, [i("div", Me, [ne(l.$slots, "header", {}, void 0, true), L.menuType === I(Z).MENU_PICK.V ? (c(), u("div", Be, [(c(true), u(T, null, V(L.systemList, (t) => (c(), w(n, { key: Math.random(t.id), label: t.label, checked: t.checked, style: F(L.currentSystem.id === t.id ? "background: #EFF2F7" : ""), indeterminate: !t.checked && t.semiChecked, border: "", onClick: (r) => he(t, r) }, { default: h(() => [i("span", null, C(t.label), 1)]), _: 2 }, 1032, ["label", "checked", "style", "indeterminate", "onClick"]))), 128))])) : (c(), u("div", Ke, [(c(true), u(T, null, V(Q.value, (t) => (c(), u("div", { key: Math.random(t.id), label: t.label, checked: t.checked, style: F([{ cursor: "pointer", padding: "8px 14px", border: "1px solid #e4e7ed", "border-radius": "3px", "font-size": "12px", "margin-left": "8px" }, { color: t.checked ? "#409EFF" : "", border: t.checked ? "1px solid #409EFF" : "1px solid #e4e7ed" }]) }, [i("span", null, C(t.label), 1)], 12, Oe))), 128))]))]), ne(l.$slots, "footer", {}, void 0, true)])]), _: 3 }), L.menuType === I(Z).MENU_PICK.V ? (c(), w(a, { key: 0, shadow: "always", style: { height: "100%" } }, { header: h(() => [i("div", null, [i("div", Fe, [i("span", ze, C(L.currentSystem.label), 1), i("div", He, [y(o, { size: "default", style: { background: "#787a7a", color: "#ffffff", border: "none" }, onClick: e[0] || (e[0] = (t) => le(true)) }, { default: h(() => e[10] || (e[10] = [$(" 展开")])), _: 1, __: [10] }), y(o, { size: "default", style: { background: "#d8d8d8", color: "#333333", border: "none" }, onClick: e[1] || (e[1] = (t) => le(false)) }, { default: h(() => e[11] || (e[11] = [$(" 收起")])), _: 1, __: [11] })])]), i("div", $e, [(c(true), u(T, null, V(b.value, (t) => (c(), w(n, { key: Math.random(t.key), checked: t.checked, label: t.label, indeterminate: !t.checked && t.semiChecked, border: "", onClick: (r) => re(t, r) }, { default: h(() => [i("span", null, C(t.label), 1)]), _: 2 }, 1032, ["checked", "label", "indeterminate", "onClick"]))), 128))])])]), default: h(() => [oe((c(), u("div", { class: "table-tree", ref_key: "tableItemRef", ref: X }, [I(P)(b.value) ? (c(), u("div", { key: M.value }, [y(K, { modelValue: N.value, "onUpdate:modelValue": e[2] || (e[2] = (t) => N.value = t) }, { default: h(() => [(c(true), u(T, null, V(b.value, (t) => (c(), w(d, { title: t.label, name: t.key, key: t.key, id: t.key }, { title: h(() => [i("span", { style: F([{ color: t.semiChecked || t.checked ? "#409eff" : "" }, { "font-weight": "bold", "font-size": "14px" }]) }, C(t.label), 5)]), default: h(() => [(c(true), u(T, null, V(t.children, (r) => (c(), w(Re, { key: r.key, item: r }, null, 8, ["item"]))), 128)), t.children ? (c(), u("div", je)) : Ee("", true)]), _: 2 }, 1032, ["title", "name", "id"]))), 128))]), _: 1 }, 8, ["modelValue"])])) : (c(), u("span", qe, "暂无数据"))])), [[Ce, s.loading]])]), _: 1 })) : (c(), w(a, { key: 1, shadow: "always", style: { height: "100%" } }, { header: h(() => [i("div", null, [i("div", Ye, [i("span", Ze, C(L.currentSystem.label), 1), i("div", Ge, [y(o, { size: "default", style: { background: "#787a7a", color: "#ffffff", border: "none" }, onClick: e[3] || (e[3] = (t) => z(true)) }, { default: h(() => e[12] || (e[12] = [$(" 展开")])), _: 1, __: [12] }), y(o, { size: "default", style: { background: "#d8d8d8", color: "#333333", border: "none" }, onClick: e[4] || (e[4] = (t) => z(false)) }, { default: h(() => e[13] || (e[13] = [$(" 收起")])), _: 1, __: [13] })])]), i("div", Je, [(c(true), u(T, null, V(A.value, (t) => (c(), u("span", { key: Math.random(t.key), label: t.label, checked: t.checked, style: F([{ cursor: "pointer", padding: "8px 14px", border: "1px solid #e4e7ed", "border-radius": "3px", "font-size": "12px", "margin-right": "8px" }, { color: t.checked ? "#409EFF" : "", border: t.checked ? "1px solid #409EFF" : "1px solid #e4e7ed" }]), onClick: (r) => ue(t, r) }, [i("span", null, C(t.label), 1)], 12, Qe))), 128))])])]), default: h(() => [i("div", { class: "table-tree", ref_key: "tableItemRef", ref: X }, [I(P)(A.value) ? (c(), u("div", { key: M.value }, [y(K, { modelValue: S.value, "onUpdate:modelValue": e[9] || (e[9] = (t) => S.value = t) }, { default: h(() => [(c(true), u(T, null, V(A.value, (t) => (c(), w(d, { title: t.label, name: t.key, key: t.key, id: t.key }, { title: h(() => [i("span", { style: F([{ color: t.checked ? "#409eff" : "" }, { "font-weight": "bold", "font-size": "14px" }]) }, C(t.label), 5)]), default: h(() => [i("div", We, [i("div", Xe, [e[14] || (e[14] = i("div", { style: { "margin-right": "20px", "font-size": "14px", "font-weight": "bold" } }, "投标信息", -1)), y(m, { modelValue: p.value, "onUpdate:modelValue": e[5] || (e[5] = (r) => p.value = r), options: I(g).ENUM, type: "enum", onChange: me }, null, 8, ["modelValue", "options"])]), oe(i("div", el, [i("div", ll, [y(n, { label: "展开/折叠", size: "default", onChange: e[6] || (e[6] = (r) => ke(r)) }), y(n, { label: "全选", size: "default", onChange: e[7] || (e[7] = (r) => pe(r)) }), y(n, { label: "父子联动", size: "default", onChange: e[8] || (e[8] = (r) => ye(r)) })]), y(H, { class: "divider", direction: "vertical", style: { height: "280px", margin: "0 60px" } }), i("div", tl, [y(be, { ref_for: true, ref: _e, class: "filter-tree", data: I(G), "empty-text": "暂无数据", props: { children: "children", label: "name" }, "check-strictly": J.value, "default-expand-all": j.value, "show-checkbox": "", "node-key": "id", onCheck: ve }, { default: h(({ node: r }) => [y(v, { style: { "margin-right": "5px", color: "#67c23a" }, "icon-class": "menu-list-BranchCompanyIcon" }), i("span", null, C(r.label), 1)]), _: 1 }, 8, ["data", "check-strictly", "default-expand-all"])])], 512), [[xe, p.value === I(g).CUSTOM_PERMISSION.V]])])]), _: 2 }, 1032, ["title", "name", "id"]))), 128))]), _: 1 }, 8, ["modelValue"])])) : (c(), u("span", al, "暂无数据"))], 512)]), _: 1 }))]);
  };
} }, ul = we(sl, [["__scopeId", "data-v-ce88c7fa"]]);
export {
  ul as default
};
