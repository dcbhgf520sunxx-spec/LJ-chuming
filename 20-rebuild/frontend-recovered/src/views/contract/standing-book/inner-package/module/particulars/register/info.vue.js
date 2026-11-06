import { ref as _ } from "vue";
import { inject as R } from "vue";
import { watchEffect as P } from "vue";
import { computed as j } from "vue";
import { watch as V } from "vue";
import { resolveDirective as K } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as f } from "vue";
import { createElementVNode as g } from "vue";
import { createVNode as m } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as k } from "vue";
import { renderSlot as Q } from "vue";
import { Fragment as C } from "vue";
import { renderList as W } from "vue";
import { createBlock as T } from "vue";
import { withDirectives as D } from "vue";
import { toDisplayString as I } from "vue";
import { createCommentVNode as A } from "vue";
import { normalizeStyle as L } from "vue";
import { unref as X } from "vue";
import { vShow as $ } from "vue";
import { ElRadioButton as Y } from "element-plus";
import { ElRadioGroup as Z } from "element-plus";
import { ElCol as ee } from "element-plus";
import { ElTooltip as ae } from "element-plus";
import { ElRow as te } from "element-plus";
import { ElTag as le } from "element-plus";
import { a as ne, b as oe } from "../../../../../../../modules/capital-de0d42db.js";
import { _ as se, i as ie, bV as ce, j1 as re } from "../../../../../../../shared/runtime.js";
import ue from "./UseDetailTable.vue.js";
import pe from "./ClassifyTable.vue.js";
import "../../../../../../../modules/useTableTotal-3d22365a.js";
import "../../../../../../../modules/contract-9b18cc88.js";
import "../components/establish/capital.vue.js";
import "../../../../../../../modules/data-039b7fd9.js";
const _e = { class: "register-info-container" }, de = { class: "radio" }, ve = { class: "endLog-table-container" }, fe = { class: "item-label" }, me = { class: "animate__animated animate__fadeIn animate__faster" }, ye = { key: 0 }, be = { __name: "info", setup(ge) {
  const u = _({}), n = _(null), b = _(), S = _([]), w = _([]), { endLogTableData: y } = R("info_parent_data"), { _commonFn: M, _commonAttribute: N, projectInfo: p } = R("parent_data");
  (async () => {
    try {
      const e = await ne(p.project.id);
      S.value = Object.entries(e).map(([a, s]) => {
        const [l, i] = Object.entries(s)[0];
        return { id: l, label: i, key: a };
      }), N.value.capitalList = S;
    } catch (e) {
      console.error("获取注资对象报错", e);
    }
  })(), (async () => {
    try {
      const { content: e } = await oe();
      w.value = e, N.value.capitalTypeList = w;
    } catch (e) {
      console.error("获取注资类型失败", e);
    }
  })(), P(async () => {
    var e, a, s, l, i;
    if (ie(b.value)) switch (b.value) {
      case "contractSignBodyAmount":
        u.value.contractSignBodyId = Number((e = S.value.find((c) => c.key === "contractSignBodyId")) == null ? void 0 : e.id), (a = u.value) != null && a.projectManagerId && delete u.value.projectManagerId, await n.value.getCapitalList();
        break;
      case "projectManagerAmount":
        u.value.projectManagerId = Number((s = S.value.find((c) => c.key === "projectManagerId")) == null ? void 0 : s.id), (l = u.value) != null && l.contractSignBodyId && delete u.value.contractSignBodyId, await n.value.getCapitalList();
        break;
      case "injectionSum":
        u.value.contractSignBodyId = null, u.value.projectManagerId = null, await n.value.getCapitalList();
        break;
    }
    else (i = n == null ? void 0 : n.value) != null && i.tableData && (n.value.tableData = []);
  });
  const x = _([{ label: "累计注资", key: "injectionSum", value: null, style: "", label_span: 2, value_span: 3, isShow: true }, { label: null, label_key: "contractSignBodyName", key: "contractSignBodyAmount", value: null, style: "", label_span: 5, value_span: 5, label_tooltip: false, isShow: true }, { label: null, label_key: "projectManagerName", key: "projectManagerAmount", value: null, style: "", label_span: 5, label_tooltip: false, value_span: 4, isShow: true }]), v = _("detail"), h = j(() => {
    var e;
    return ((e = y == null ? void 0 : y.value[0]) == null ? void 0 : e.contractSignBodyScale) || "0";
  }), B = j(() => {
    var e;
    return ((e = y == null ? void 0 : y.value[0]) == null ? void 0 : e.projectManagerScale) || "0";
  }), o = _(), E = async () => {
    try {
      o.value = [], o.value = JSON.parse(JSON.stringify(x.value));
      const e = await re.get(`/api/contract/Injection/getAssetInjection/${p.project.id}`);
      for (const [l, i] of Object.entries(e)) o.value.forEach((c) => {
        c.key === l && (c.value = i), c.label_key === l && (c.label = i);
      });
      const a = o.value.find((l) => l.key === "contractSignBodyAmount"), s = o.value.find((l) => l.key === "projectManagerAmount");
      p.projectAttribute === 2 ? a.isShow = true : (s.label += " 剩余金额", a.isShow = false), console.log(o);
    } catch (e) {
      console.error("获取注资信息失败:getItemRegisterInfo", e);
    }
  };
  M.value.getItemRegisterInfo = E;
  function F() {
    p.projectAttribute === 2 && (h.value && (o.value[1].label += ` ( ${parseFloat(h.value)}% ) 剩余金额`), B.value && (o.value[2].label += ` ( ${parseFloat(B.value)}% ) 剩余金额`));
  }
  M.value.tidyHeaderInfo = F, V([() => h.value, () => B.value, () => {
    var e;
    return (e = p == null ? void 0 : p.project) == null ? void 0 : e.id;
  }], async ([e, a, s]) => {
    s && (b.value = null, await E(), p.projectAttribute === 2 && (e && (o.value[1].label += ` ( ${parseFloat(e)}% ) 剩余金额`), a && (o.value[2].label += ` ( ${parseFloat(a)}% ) 剩余金额`)));
  }, { immediate: true }), V(() => v.value, (e) => {
    e === "useDetail" && (b.value = null);
  });
  const O = (e, a) => {
    v.value !== "useDetail" && (b.value = e);
  }, U = j(() => v.value === "detail" && n.value && n.value.tableData.length !== 0), z = j(() => n.value && n.value.tableData.length === 0 && v.value === "detail");
  return (e, a) => {
    const s = Y, l = Z, i = ee, c = ae, H = te, J = le, q = K("ellipsis");
    return r(), f(C, null, [g("div", _e, [m(l, { modelValue: v.value, "onUpdate:modelValue": a[0] || (a[0] = (t) => v.value = t), class: "box-container radio-container" }, { default: d(() => [g("div", de, [m(s, { value: "detail" }, { default: d(() => a[1] || (a[1] = [k("注资信息")])), _: 1, __: [1] }), m(s, { value: "useDetail" }, { default: d(() => a[2] || (a[2] = [k("支出明细")])), _: 1, __: [2] })]), Q(e.$slots, "createDarwer", {}, void 0, true)]), _: 3 }, 8, ["modelValue"]), g("div", ve, [m(H, { class: "animate__animated animate__fadeIn" }, { default: d(() => [(r(true), f(C, null, W(o.value, (t, G) => (r(), f(C, { key: G }, [t.isShow ? (r(), T(i, { key: 0, span: t.label_span, class: "col-container center", style: { cursor: "pointer" }, onClick: (ke) => O(t.key) }, { default: d(() => [D((r(), f("span", fe, [k(I(t.label), 1)])), [[q]])]), _: 2 }, 1032, ["span", "onClick"])) : A("", true), t.isShow ? (r(), T(i, { key: 1, span: t.value_span, class: "col-container value-col" }, { default: d(() => [t.tooltip ? (r(), T(c, { key: 0, content: t.value, placement: "right-start" }, { default: d(() => [g("span", { style: L(t.style) }, I(t.value), 5)]), _: 2 }, 1032, ["content"])) : t.defaultValue && !t.value ? (r(), f("span", { key: 1, style: L(t.style) }, I(t.defaultValue), 5)) : (r(), f("span", { key: 2, style: L(t.style) }, I(X(ce)(t.value)), 5))]), _: 2 }, 1032, ["span"])) : A("", true)], 64))), 128))]), _: 1 })]), D(g("div", me, [m(pe, { ref_key: "classifyRef", ref: n, form: u.value }, null, 8, ["form"])], 512), [[$, U.value]]), D(m(ue, { class: "animate__animated animate__fadeIn animate__faster" }, null, 512), [[$, v.value === "useDetail"]])]), z.value ? (r(), f("div", ye, [m(J, { size: "large" }, { default: d(() => a[3] || (a[3] = [k("* 点击标题可查看对应列表数据")])), _: 1, __: [3] })])) : A("", true)], 64);
  };
} }, Ne = se(be, [["__scopeId", "data-v-847bc453"]]);
export {
  Ne as default
};
