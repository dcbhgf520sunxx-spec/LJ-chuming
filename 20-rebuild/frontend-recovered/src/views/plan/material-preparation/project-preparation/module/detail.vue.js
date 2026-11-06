import { inject as R } from "vue";
import { ref as I } from "vue";
import { computed as oe } from "vue";
import { resolveComponent as se } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as b } from "vue";
import { createElementVNode as i } from "vue";
import { unref as e } from "vue";
import { createBlock as A } from "vue";
import { toDisplayString as N } from "vue";
import { normalizeClass as he } from "vue";
import { normalizeStyle as J } from "vue";
import { Fragment as F } from "vue";
import { renderList as G } from "vue";
import { createCommentVNode as H } from "vue";
import { ElCheckbox as pe } from "element-plus";
import { provide as B } from "vue";
import { watch as O } from "vue";
import { nextTick as ae } from "vue";
import me from "lodash";
import { createVNode as y } from "vue";
import { withCtx as d } from "vue";
import { renderSlot as ce } from "vue";
import { createTextVNode as j } from "vue";
import { withDirectives as V } from "vue";
import { ElCard as fe } from "element-plus";
import { ElCollapseItem as _e } from "element-plus";
import { ElCollapse as ye } from "element-plus";
import { vLoading as ke } from "element-plus";
import { resolveDirective as Q } from "vue";
import { ElFormItem as ve } from "element-plus";
import { ElDivider as Ce } from "element-plus";
import { ElForm as be } from "element-plus";
import { _ as ne, i as x, b as P, m as Ee, sH as X, l as ge, V as re, sD as Z, gt as Se, ho as Ne, jZ as de, jJ as te, am as Y, bD as ie, jT as Te, bR as Ve, jU as xe, jV as De, jO as le, iF as ue, z as we, R as Ue, S as Ie } from "../../../../../shared/runtime.js";
const Le = { key: 1, class: "label-text" }, Me = { name: "TableItem" }, He = Object.assign(Me, { props: { item: { type: Object, default: () => ({}) } }, setup(K, { expose: $ }) {
  const w = K, l = { CHECKED: 1, SEMI_CHECKED: 2, UN_CHECKED: 3, UN_SEMI_CHECKED: 4 }, n = R("checkedSet"), L = R("checkStrictly"), k = R("returnLeaf"), c = R("returnIndeterminate"), r = R("disabled"), U = R("checkable"), C = R("onlyShowChecked"), u = I(w.item), p = I(true), o = oe(() => !u.value.checked && u.value.semiChecked), g = oe(() => C ? u.value.checked || u.value.semiChecked : true);
  function S(M) {
    (!k || k && P(u.value.children)) && (M ? n.value.add(u.value.key) : n.value.delete(u.value.key)), u.value.semiChecked = M;
    const a = M ? l.CHECKED : l.UN_CHECKED;
    L || (_(u.value, a), z(u.value, a));
  }
  function _(M, E) {
    let a;
    const t = M.parent;
    if (!t) return;
    const f = !k || k && P(t.children);
    if (c && f && (M.checked || M.semiChecked ? n.value.add(t.key) : (t.checked || t.semiChecked) && (t.children.some((v) => v.semiChecked || v.checked) || n.value.delete(t.key))), E === l.CHECKED) {
      t.semiChecked || (t.semiChecked = true, a = l.SEMI_CHECKED), t.checked = t.children.every((s) => s.checked), t.checked && (a = l.CHECKED, f && n.value.add(t.key)), a && x(t.parent) && _(t, a);
      return;
    }
    if (E === l.SEMI_CHECKED) {
      t.semiChecked || (t.semiChecked = true, a = l.SEMI_CHECKED), a && x(t.parent) && _(t, a);
      return;
    }
    if (E === l.UN_CHECKED) {
      let s = true;
      const v = t.children.some((q) => q.semiChecked || q.checked);
      v === t.semiChecked && !t.checked && (s = false), t.semiChecked = v, t.checked && (t.checked = false, f && !c && n.value.delete(t.key)), s && x(t.parent) && _(t, l.UN_CHECKED);
      return;
    }
  }
  function z(M, E) {
    const a = M.children || [];
    E === l.CHECKED && a.forEach((t) => {
      const f = !k || k && P(t.children);
      t.semiChecked = true, t.checked = true, f && n.value.add(t.key), x(t.children) && z(t, E);
    }), E === l.UN_CHECKED && a.forEach((t) => {
      const f = !k || k && P(t.children);
      t.semiChecked = false, t.checked = false, f && n.value.delete(t.key), x(t.children) && z(t, E);
    });
  }
  function ee() {
    p.value = !p.value;
  }
  return $({ handleChange: S, setChildNode: z }), (M, E) => {
    const a = pe, t = se("table-item", true);
    return g.value ? (m(), b("div", { key: 0, class: "tree-item", style: J({ "border-bottom": u.value.isSecondLevel || u.value.children ? "1px solid #e5e5e5" : "none", "border-left": e(x)(u.value.parent.parent) ? "none" : "1px solid #e5e5e5", "border-right": e(x)(u.value.parent.parent) ? "none" : "1px solid #e5e5e5" }) }, [i("div", { class: "tree-item-left", onClick: ee }, [e(U) ? (m(), A(a, { key: 0, modelValue: u.value.checked, "onUpdate:modelValue": E[0] || (E[0] = (f) => u.value.checked = f), indeterminate: o.value, label: u.value.label, disabled: e(r), onChange: S }, null, 8, ["modelValue", "indeterminate", "label", "disabled"])) : (m(), b("span", Le, N(u.value.label), 1))]), e(x)(u.value.children) ? (m(), b("div", { key: 0, class: he(["tree-item-right", u.value.isSecondLevel && u.value.children ? "tree-item-right-last" : ""]), style: J({ "border-left": u.value.isSecondLevel || u.value.children ? "1px solid #e5e5e5" : "none" }) }, [(m(true), b(F, null, G(u.value.children, (f) => (m(), A(t, { key: f.key, item: f }, null, 8, ["item"]))), 128))], 6)) : H("", true), E[1] || (E[1] = i("div", { class: "tree-item-clear" }, null, -1))], 4)) : H("", true);
  };
} }), Ae = ne(He, [["__scopeId", "data-v-7e52268f"]]);
const Ke = { class: "dialog-header" }, Re = { style: { display: "flex", "align-content": "center", "align-items": "center" } }, je = { class: "card-header", style: { "margin-bottom": "15px" } }, Oe = { style: { "margin-bottom": "10px", "font-size": "14px", "font-weight": "bold" } }, $e = { style: { float: "right" } }, Be = { class: "checkbox-container" }, Fe = { key: 0, style: { width: "100%", height: "1px", "border-top": "1px solid #8dabc3", "margin-top": "20px" } }, Pe = { key: 1, class: "tip" }, ze = { __name: "index", props: { options: { type: Array, default: () => [] }, modelValue: { type: Array, default: () => [] }, checkStrictly: { type: Boolean, default: false }, checkable: { type: Boolean, default: false }, onlyShowChecked: { type: Boolean, default: false }, returnLeaf: { type: Boolean, default: true }, returnIndeterminate: { type: Boolean, default: false }, isDeleteNonexistent: { type: Boolean, default: true }, disabled: { type: Boolean, default: false }, loading: { type: Boolean, default: false }, dataStructure: { type: Object, default: () => ({ key: "id", label: "label", children: "children" }) } }, emits: ["update:modelValue", "change", "systemTypeChange"], setup(K, { emit: $ }) {
  const { user: w } = Ee(["user"]), l = $, n = K, L = R("systemType"), k = { CHECKED: 1, SEMI_CHECKED: 2, UN_CHECKED: 3, UN_SEMI_CHECKED: 4 }, c = I(), r = I([]), U = I(), C = I([]), u = I(1), p = I([]), o = I([]);
  B("checkedSet", c), B("checkStrictly", n.checkStrictly), B("returnLeaf", n.returnLeaf), B("returnIndeterminate", n.returnIndeterminate), B("disabled", n.disabled), B("checkable", n.checkable), B("onlyShowChecked", n.onlyShowChecked);
  for (const a in X.ENUM) w.value.menuSystemEnum.includes(X.ENUM[a].V) && o.value.push(X.ENUM[a]);
  O(() => n.options, (a) => {
    n.loading || ae(() => {
      u.value += 1, C.value = S(a);
    });
  }, { immediate: true, deep: true }), O(() => C.value, () => {
    C.value.length && (o.value = o.value.map((a) => ((a == null ? void 0 : a.V) === L.value && (a.checked = C.value.every((t) => t.checked), a.semiChecked = C.value.some((t) => t.semiChecked || t.checked)), a)));
  }, { immediate: true, deep: true }), O(() => n.modelValue, (a) => {
    c.value = new Set(a);
  }, { immediate: true, deep: true }), O(c, () => {
    z();
  }, { immediate: true, deep: true });
  const g = (a) => {
    a ? r.value = C.value.map((t) => t.key) : r.value = [];
  };
  function S(a) {
    const t = me.cloneDeep(c.value);
    p.value = [];
    const f = _(a, null, t, p.value);
    if (n.isDeleteNonexistent && t && t.forEach((s) => {
      c.value.delete(s);
    }), n.returnIndeterminate) {
      const s = [...n.modelValue, ...p.value];
      l("change", s), l("update:modelValue", s);
    }
    return f;
  }
  function _(a = [], t, f, s) {
    return a.map((v, q) => {
      var h;
      const W = (h = c.value) == null ? void 0 : h.has(v[n.dataStructure.key]);
      W && f.delete(v[n.dataStructure.key]);
      const D = { parent: t, key: v[n.dataStructure.key], label: v[n.dataStructure.label], checked: W, semiChecked: false, children: void 0, isSecondLevel: false, isFirstLevel: q };
      return x(v[n.dataStructure.children]) && (D.children = _(v.children, D, f, s), D.semiChecked = D.children.some((T) => T.semiChecked || T.checked), D.checked = D.children.every((T) => T.checked), D.children.every((T) => !x(T.children)) ? D.isSecondLevel = true : D.children.forEach((T) => {
        x(T.children) || (T.isSecondLevel = true);
      })), D.semiChecked && !D.checked && s && s.push(D.key), D;
    });
  }
  function z() {
    const a = Array.from(c.value);
    a.equals(n.modelValue) || (l("update:modelValue", a), l("change", a));
  }
  function ee(a, t) {
    const f = t.target;
    if (f.classList.contains("el-checkbox__inner")) {
      a.checked = !a.checked, a.semiChecked = false, a.checked ? c.value.add(a.key) : c.value.delete(a.key);
      const s = a.checked ? k.CHECKED : k.UN_CHECKED;
      E(a, s);
    } else f.classList.contains("el-checkbox__original") || (t.preventDefault(), r.value.indexOf(a.key) !== -1 ? r.value = r.value.filter((s) => s !== a.key) : r.value = [...r.value, a.key], ae(() => {
      document.getElementById(`${a.key}`).scrollIntoView({ behavior: "smooth", block: "start" });
    }));
  }
  const M = (a, t) => {
    const f = t.target;
    f.classList.contains("el-checkbox__inner") && L.value === a.V ? (a.checked = !a.checked, a.checked ? C.value.forEach((s) => {
      s.checked = true, s.semiChecked = false, c.value.add(s.key);
      const v = s.checked ? k.CHECKED : k.UN_CHECKED;
      E(s, v);
    }) : C.value.forEach((s) => {
      s.checked = false, s.semiChecked = false, c.value.delete(s.key);
      const v = s.checked ? k.CHECKED : k.UN_CHECKED;
      E(s, v);
    })) : f.classList.contains("el-checkbox__original") || (t.preventDefault(), L.value = a.V, l("systemTypeChange", L.value));
  };
  function E(a, t) {
    const f = a.children || [];
    t === k.CHECKED && f.forEach((s) => {
      const v = !n.returnLeaf || n.returnLeaf && P(s.children);
      s.semiChecked = true, s.checked = true, v && c.value.add(s.key), x(s.children) && E(s, t);
    }), t === k.UN_CHECKED && f.forEach((s) => {
      const v = !n.returnLeaf || n.returnLeaf && P(s.children);
      s.semiChecked = false, s.checked = false, v && c.value.delete(s.key), x(s.children) && E(s, t);
    });
  }
  return (a, t) => {
    const f = pe, s = fe, v = se("common-button"), q = _e, W = ye, D = ke;
    return m(), b(F, null, [y(s, { style: { "margin-bottom": "10px", height: "80px" }, shadow: "always" }, { default: d(() => [i("div", Ke, [i("div", Re, [ce(a.$slots, "header", {}, void 0, true), (m(true), b(F, null, G(o.value, (h) => (m(), A(f, { key: Math.random(h.V), label: h.L, checked: h.checked, indeterminate: !h.checked && h.semiChecked, border: "", onClick: (T) => M(h, T) }, { default: d(() => [i("span", null, N(h.L), 1)]), _: 2 }, 1032, ["label", "checked", "indeterminate", "onClick"]))), 128))]), ce(a.$slots, "footer", {}, void 0, true)])]), _: 3 }), y(s, { shadow: "always", style: { height: "100%" } }, { header: d(() => [i("div", null, [i("div", je, [i("span", Oe, N(e(X).V[e(L)].L), 1), i("div", $e, [y(v, { type: "primary", size: "default", onClick: t[0] || (t[0] = (h) => g(true)) }, { default: d(() => t[3] || (t[3] = [j("全部展开")])), _: 1, __: [3] }), y(v, { type: "info", size: "default", onClick: t[1] || (t[1] = (h) => g(false)) }, { default: d(() => t[4] || (t[4] = [j(" 全部收起")])), _: 1, __: [4] })])]), i("div", Be, [(m(true), b(F, null, G(C.value, (h) => (m(), A(f, { key: Math.random(h.key), checked: h.checked, label: h.label, indeterminate: !h.checked && h.semiChecked, border: "", onClick: (T) => ee(h, T) }, { default: d(() => [i("span", null, N(h.label), 1)]), _: 2 }, 1032, ["checked", "label", "indeterminate", "onClick"]))), 128))])])]), default: d(() => [V((m(), b("div", { class: "table-tree", ref_key: "tableItemRef", ref: U }, [e(x)(C.value) ? (m(), b("div", { key: u.value }, [y(W, { modelValue: r.value, "onUpdate:modelValue": t[2] || (t[2] = (h) => r.value = h) }, { default: d(() => [(m(true), b(F, null, G(C.value, (h) => (m(), A(q, { title: h.label, name: h.key, key: h.key, id: h.key }, { title: d(() => [i("span", { style: J([{ color: Array.from(c.value).includes(h.key) ? "#409eff" : "" }, { "font-weight": "bold", "font-size": "14px" }]) }, N(h.label), 5)]), default: d(() => [(m(true), b(F, null, G(h.children, (T) => (m(), A(Ae, { key: T.key, item: T }, null, 8, ["item"]))), 128)), h.children ? (m(), b("div", Fe)) : H("", true)]), _: 2 }, 1032, ["title", "name", "id"]))), 128))]), _: 1 }, 8, ["modelValue"])])) : (m(), b("span", Pe, "暂无数据"))])), [[D, n.loading]])]), _: 1 })], 64);
  };
} }, qe = ne(ze, [["__scopeId", "data-v-dd56c34e"]]);
function Ze(K) {
  return ge({ module: "plan", url: "branch-sub-items/area/tree/outsourcing", method: "get", params: K });
}
const Ge = { __name: "outsourcing-area-table-tree", props: { modelValue: { type: Array }, struc: { type: Array }, encl: { type: Array }, showStruc: { type: Boolean, default: false }, showEncl: { type: Boolean, default: false }, projectIds: [Array, Number], disabled: { type: Boolean, default: false } }, emits: ["change", "update:modelValue", "update:struc", "update:encl"], setup(K, { emit: $ }) {
  const w = $, l = K, n = I([]), L = I([]), k = I(false), c = I([]);
  O([() => l.struc, () => l.encl], ([p, o]) => {
    c.value = C(p, o);
  }, { immediate: true, deep: true }), O(() => l.projectIds, (p) => {
    r(p);
  }, { immediate: true }), O([() => l.showStruc, () => l.showEncl], () => {
    n.value = U(re(L.value));
  });
  async function r(p) {
    if (P(p)) {
      n.value = [];
      return;
    }
    k.value = true;
    try {
      const o = await Ze(p);
      L.value = o, n.value = U(re(o));
    } catch (o) {
      console.log("外包区域", o);
    } finally {
      k.value = false;
    }
  }
  function U(p = []) {
    return p.filter((o) => {
      const g = !o.type, S = l.showStruc && o.type && o.type === Z.STRUCTURE.V, _ = l.showEncl && o.type && o.type === Z.ENCLOSURE.V;
      return g || S || _;
    }).map((o) => (o.uid = o.type ? `${o.type}_${o.id}` : o.id, x(o.children) && (o.children = U(o.children)), o));
  }
  function C(p = [], o = []) {
    const g = [];
    return p.forEach((S) => {
      g.push(`${Z.STRUCTURE.V}_${S}`);
    }), o.forEach((S) => {
      g.push(`${Z.ENCLOSURE.V}_${S}`);
    }), g;
  }
  function u(p) {
    const o = [], g = [], S = Array.from(p).map((_) => typeof _ == "string" ? _.split("_") : _).filter((_) => _.length === 2);
    S.forEach((_) => {
      +_[0] === Z.STRUCTURE.V && o.push(_[1]), +_[0] === Z.ENCLOSURE.V && g.push(_[1]);
    }), w("change", S), w("update:modelValue", S), w("update:encl", g), w("update:struc", o);
  }
  return (p, o) => (m(), A(qe, { modelValue: c.value, "onUpdate:modelValue": o[0] || (o[0] = (g) => c.value = g), options: n.value, loading: k.value, disabled: l.disabled, "data-structure": { key: "uid", label: "name", children: "children" }, onChange: u }, null, 8, ["modelValue", "options", "loading", "disabled"]));
} };
const Je = { class: "main-content" }, We = { class: "form-content" }, Qe = { key: 0 }, Xe = { class: "flex-rss child-mr-10" }, Ye = { key: 0 }, et = { class: "input-underline flex-rss child-mr-10" }, tt = { key: 0 }, lt = { key: 0 }, at = { style: { "word-break": "break-all" } }, st = { class: "pre-wrap" }, nt = { key: 0, class: "pre-wrap" }, ot = { __name: "detail", setup(K) {
  const { CRUD: $, crud: w, detail: l } = Se(), { loaded: n, rawMatClsKV: L } = Ne();
  return $.HOOK.beforeDetailLoaded = (k, c) => {
    const r = () => {
      c.auxMaterialIds && (c.auxMaterialNames = c.auxMaterialIds.map((U) => {
        const C = L.value[U];
        return C ? C.name : "-";
      }));
    };
    if (n.value) r();
    else {
      const U = O(n, (C) => {
        C && (r(), ae(() => {
          U();
        }));
      }, { immediate: true });
    }
  }, (k, c) => {
    const r = ve, U = Ce, C = be, u = se("common-drawer"), p = Q("parse-enum"), o = Q("split"), g = Q("empty-text"), S = Q("parse-time");
    return m(), A(u, { ref: "drawerRef", visible: e(w).detailVisible, "content-loading": !e(n) || e(w).detailLoading, "before-close": e(w).cancelDetail, title: e(w).detailTitle, "show-close": true, size: 1e3, "custom-class": "purchase-order-detail" }, { content: d(() => [i("div", Je, [y(C, { model: e(l), size: "default", "label-position": "left", "label-width": "100px" }, { default: d(() => [i("div", We, [y(r, { label: "签订主体", prop: "branchCompanyName", style: { width: "100%" } }, { default: d(() => [e(l).branchCompany ? (m(), b("span", Qe, N(e(l).branchCompany.name), 1)) : H("", true)]), _: 1 }), y(r, { label: "采购合同编号", prop: "serialNumber" }, { default: d(() => [j(N(e(l).serialNumber), 1)]), _: 1 }), y(r, { label: "供货类型", prop: "supplyType" }, { default: d(() => [V(i("span", null, null, 512), [[p, { e: e(de), v: e(l).supplyType }]])]), _: 1 }), y(r, { label: "物料种类", prop: "basicClass" }, { default: d(() => [i("div", Xe, [V(i("span", null, null, 512), [[p, { e: e(te), v: e(l).purchaseType, extra: "：" }]]), V(i("span", null, null, 512), [[p, { e: e(Y), v: e(l).basicClass, bit: true, split: " | " }]])])]), _: 1 }), y(r, { label: "供应商", prop: "supplier" }, { default: d(() => [e(l).supplier ? (m(), b("span", Ye, N(e(l).supplier.name), 1)) : H("", true)]), _: 1 }), e(l).basicClass & e(Y).MATERIAL.V ? (m(), A(r, { key: 0, label: "辅材明细", prop: "auxMaterialNames", style: { width: "100%", "word-break": "break-all" } }, { default: d(() => [V(i("span", null, null, 512), [[o, e(l).auxMaterialNames]])]), _: 1 })) : H("", true), e(l).supplyType == e(de).SELF.V ? (m(), b(F, { key: 1 }, [y(r, { label: "合同量", prop: "mete" }, { default: d(() => [i("div", et, N(e(l).mete) + " " + N(e(l).meteUnit), 1)]), _: 1 }), y(r, { label: "合同额", prop: "amount" }, { default: d(() => [j(N(e(l).amount) + "元 ", 1)]), _: 1 }), y(r, { label: "发票及税率", prop: "invoiceType" }, { default: d(() => [V(i("span", null, null, 512), [[p, { e: e(ie), v: e(l).invoiceType }]]), e(l).invoiceType !== e(ie).RECEIPT.V ? (m(), b("span", tt, "（" + N(e(l).taxRate) + "%）", 1)) : H("", true)]), _: 1 }), y(r, { label: "订单类型", prop: "purchaseOrderPaymentMode" }, { default: d(() => [V(i("span", null, null, 512), [[p, { e: e(Te), v: e(l).purchaseOrderPaymentMode }]])]), _: 1 })], 64)) : H("", true), y(r, { prop: "weightMeasurementMode", label: "计量方式" }, { default: d(() => [V(i("span", null, null, 512), [[p, { e: e(Ve), v: e(l).weightMeasurementMode }]])]), _: 1 }), y(r, { label: "物流信息", prop: "logistics" }, { default: d(() => [V(i("span", null, null, 512), [[p, { e: e(xe), v: e(l).logisticsTransportType }]]), c[3] || (c[3] = j(" （费用")), V(i("span", null, null, 512), [[p, { e: e(De), v: e(l).logisticsPayerType }]]), c[4] || (c[4] = j("） "))]), _: 1, __: [3, 4] }), y(r, { label: "采购状态", prop: "purchaseStatus" }, { default: d(() => [V(i("span", { style: J({ color: e(l).purchaseStatus === e(le).FINISHED.V ? "green" : "" }) }, null, 4), [[p, { e: e(le), v: e(l).purchaseStatus }]]), e(l).boolUsed && e(l).purchaseStatus === e(le).UNFINISHED.V ? (m(), b("span", lt, "（有入库）")) : H("", true)]), _: 1 }), y(r, { label: "结算状态", prop: "settlementStatus" }, { default: d(() => [V(i("span", { style: J({ color: e(l).settlementStatus === e(ue).SETTLED.V ? "green" : "" }) }, null, 4), [[p, { e: e(ue), v: e(l).settlementStatus }]])]), _: 1 }), y(r, { label: "创建人", prop: "applicantName" }, { default: d(() => [V((m(), b("span", null, [j(N(e(l).applicantName), 1)])), [[g]])]), _: 1 }), y(r, { label: "最后操作人", prop: "lastOperatorName" }, { default: d(() => [V((m(), b("span", null, [j(N(e(l).lastOperatorName), 1)])), [[g]])]), _: 1 }), y(r, { label: "创建时间", prop: "applicantName" }, { default: d(() => [V(i("span", null, null, 512), [[S, e(l).createTime]])]), _: 1 }), y(r, { label: "编辑时间", prop: "applicantName" }, { default: d(() => [V(i("span", null, null, 512), [[S, e(l).userUpdateTime]])]), _: 1 }), y(r, { label: "备注", prop: "remark" }, { default: d(() => [i("span", at, N(e(l).remark), 1)]), _: 1 }), y(r, { label: "申购单号", prop: "requisitionsSN" }, { default: d(() => [i("span", st, N(e(l).requisitionsSN ? e(l).requisitionsSN.join(`
`) : ""), 1)]), _: 1 }), y(r, { label: "关联项目", class: "el-form-item-4", prop: "projectIds", style: { width: "100%" } }, { default: d(() => [e(te).RAW_MATERIAL.V === e(l).purchaseType ? (m(), b("span", nt, N(e(l).projects ? e(l).projects.map((_) => e(we)(_, null, false)).join(`
`) : ""), 1)) : H("", true)]), _: 1 }), e(te).MANUFACTURED.V === e(l).purchaseType && e(l).basicClass && e(x)(e(l).projectIds) ? (m(), A(Ge, { key: 2, struc: e(l).strucAreaIds, "onUpdate:struc": c[0] || (c[0] = (_) => e(l).strucAreaIds = _), encl: e(l).enclAreaIds, "onUpdate:encl": c[1] || (c[1] = (_) => e(l).enclAreaIds = _), "show-struc": !!(e(l).basicClass & e(Y).STRUC_MANUFACTURED.V), "show-encl": !!(e(l).basicClass & e(Y).ENCL_MANUFACTURED.V), "project-ids": e(l).projectIds, "only-show-checked": "", style: { width: "100%" } }, null, 8, ["struc", "encl", "show-struc", "show-encl", "project-ids"])) : H("", true), y(U, null, { default: d(() => c[5] || (c[5] = [i("span", { class: "title" }, "附件", -1)])), _: 1, __: [5] }), y(Ue, { "show-download": "", "file-classify": e(Ie).PURCHASE_ORDER_ATT.V, files: e(l).attachments, "onUpdate:files": c[2] || (c[2] = (_) => e(l).attachments = _), uploadable: false, "empty-text": "暂未上传采购合同编号附件" }, null, 8, ["file-classify", "files"])])]), _: 1 }, 8, ["model"])])]), _: 1 }, 8, ["visible", "content-loading", "before-close", "title"]);
  };
} }, it = ne(ot, [["__scopeId", "data-v-70951298"]]);
export {
  it as default
};
