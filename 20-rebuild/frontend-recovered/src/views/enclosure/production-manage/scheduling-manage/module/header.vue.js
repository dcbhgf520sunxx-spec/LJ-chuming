import { computed as L } from "vue";
import { watch as P } from "vue";
import { nextTick as G } from "vue";
import { ref as u } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as b } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as d } from "vue";
import { vShow as ye } from "vue";
import { unref as s } from "vue";
import { createElementVNode as f } from "vue";
import { createVNode as r } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as he } from "vue";
import { Fragment as be } from "vue";
import { renderList as ke } from "vue";
import { createBlock as j } from "vue";
import { toDisplayString as R } from "vue";
import { ElMessage as H } from "element-plus";
import { ElMessageBox as Ee } from "element-plus";
import { ElCheckbox as Ve } from "element-plus";
import { ElCheckboxGroup as Ce } from "element-plus";
import { ElTag as xe } from "element-plus";
import { ElFormItem as Ie } from "element-plus";
import { ElCascader as Le } from "element-plus";
import { ElDatePicker as we } from "element-plus";
import { ElForm as je } from "element-plus";
import { vLoading as Se } from "element-plus";
import { b as Te, d as Ue, e as De, f as Me } from "../../../../../modules/scheduling-manage-9a6dc016.js";
import { _ as Ne, B as Oe, kA as B, D as S, E as Re } from "../../../../../shared/runtime.js";
import { u as Be } from "../../../../../modules/use-scheduling-groups-b1c4e979.js";
const Qe = { class: "filter-item" }, qe = { class: "area-wrap" }, ze = { key: 0 }, Fe = { __name: "header", props: { project: { type: Object, default: () => {
} } }, emits: ["refreshProject"], setup(K, { emit: $ }) {
  const J = $, W = { category: void 0, planIds: [] }, { crud: _, query: l, CRUD: X } = Oe(W), Y = L(() => ({ type: l.category })), { groupsTree: Z, groupsObj: ee } = Be({ queryParams: Y }), te = L(() => Object.keys(B.V).map((t) => +t)), ae = L(() => _.selections.reduce((e, o) => (e += +o.totalLength, e), 0).toFixed(S.MES_ENCLOSURE_L__M)), m = K;
  P(() => m.project, (t) => {
    t != null && t.id && G(() => {
      z();
    });
  }, { immediate: true, deep: true }), P(() => l.category, (t) => {
    G(() => {
      re();
    });
  }, { immediate: true });
  const T = u([]), k = u(false), U = u(false), i = u([]), E = u(false), D = u(false), h = u(false), M = u(false), c = u({}), Q = u(), V = u(false), C = u({}), le = L(() => {
    const t = i.value.filter((e) => l.planIds.includes(e.id)).map((e) => e.date);
    return Math.min(...t);
  }), oe = { teamId: [{ required: true, message: "请选择班组", trigger: "change" }], askCompleteTime: [{ required: true, message: "请选择完成时间", trigger: "change" }] }, q = (t) => {
    l.planIds = t ? i.value.map((e) => e.id) : [], D.value = false, _.toQuery();
  }, ne = (t) => {
    const e = t.length;
    E.value = e === i.value.length, D.value = e > 0 && e < i.value.length, _.toQuery();
  };
  async function se() {
    try {
      V.value = true, C.value = {}, C.value = await De({ projectId: m.project.id, planIds: l.planIds, category: l.category });
    } catch (t) {
      console.log("获取获取围护汇总失败", t);
    } finally {
      V.value = false;
    }
  }
  async function z() {
    try {
      T.value = [];
      const t = l.category;
      l.category = void 0, k.value = true;
      const e = await Te({ projectId: m.project.id });
      e.sort((o, v) => o - v), e.length ? e.includes(t) ? l.category = t : l.category = e[0] : J("refreshProject"), T.value = te.value.filter((o) => !e.includes(o));
    } catch {
      console.log("获取所有项目下全部的围护种类失败");
    } finally {
      setTimeout(() => {
        k.value = false;
      }, 160);
    }
  }
  async function re() {
    var t;
    try {
      if (i.value = [], l.planIds = [], !l.category || !((t = m.project) != null && t.id)) return;
      U.value = true, i.value = await Ue({ category: l.category, projectId: m.project.id }), i.value.length && (q(true), E.value = true);
    } catch {
      console.log("获取围护批次失败");
    } finally {
      U.value = false;
    }
  }
  async function ue() {
    var t;
    try {
      if (M.value = true, !await Q.value.validate()) return;
      const o = _.selections.filter((y) => typeof y.taskQuantity == "number" && y.taskQuantity > 0);
      if (!o.length) {
        H.error("没有填写任务数");
        return;
      }
      Number(c.value.askCompleteTime) > Number(le.value) && await Ee.confirm("完成日期大于计划日期，是否下发？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" });
      const v = ((t = ee.value) == null ? void 0 : t[c.value.teamId]) || {};
      await Me({ ...c.value, category: l.category, projectId: m.project.id, factoryId: v.factory.id, workshopId: v.workshop.id, productionLineId: v.productionLine.id, schedulings: o.map((y) => ({ productId: y.id, quantity: y.taskQuantity })) }), h.value = false, c.value = {}, H.success("任务下发成功"), z();
    } catch (e) {
      console.log(e, "任务下发失败");
    } finally {
      M.value = false;
    }
  }
  function ie(t) {
    var e;
    return t > ((e = m.project) == null ? void 0 : e.endDate);
  }
  return X.HOOK.handleRefresh = async (t, { data: e }) => {
    t.query.category && t.query.planIds && se(), e.content.forEach((o) => {
      o.totalLength = (o.length * o.needSchedulingQuantity / 1e3).toFixed(S.MES_ENCLOSURE_L__M), o.taskQuantity = o.needSchedulingQuantity;
    });
  }, (t, e) => {
    const o = Ve, v = O("common-radio-button"), y = Ce, F = O("common-button"), N = xe, x = Ie, de = Le, ce = we, me = je, pe = O("common-dialog"), I = Se, fe = b("parse-time"), ge = b("permission"), _e = b("parse-project"), ve = b("empty-text"), A = b("thousand");
    return p(), w("div", null, [d(f("div", null, [f("span", Qe, [r(o, { modelValue: E.value, "onUpdate:modelValue": e[0] || (e[0] = (a) => E.value = a), indeterminate: D.value, disabled: !i.value.length, border: "", onChange: q }, { default: n(() => e[7] || (e[7] = [g(" 批次全选 ")])), _: 1, __: [7] }, 8, ["modelValue", "indeterminate", "disabled"])]), d(r(v, { modelValue: s(l).category, "onUpdate:modelValue": e[1] || (e[1] = (a) => s(l).category = a), options: k.value ? [] : s(B).ENUM, type: "enum", unshowVal: T.value, class: "filter-item", size: "default" }, null, 8, ["modelValue", "options", "unshowVal"]), [[I, k.value]]), d((p(), w("div", qe, [i.value.length ? he("", true) : (p(), w("span", ze, "暂无批次")), r(y, { modelValue: s(l).planIds, "onUpdate:modelValue": e[2] || (e[2] = (a) => s(l).planIds = a), onChange: ne }, { default: n(() => [(p(true), w(be, null, ke(i.value, (a) => (p(), j(o, { key: a.id, value: a.id }, { default: n(() => [g(R(a.name) + " / 交货期：", 1), d(f("span", null, null, 512), [[fe, { val: a.date, fmt: "{y}-{m}-{d}" }]])]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue"])])), [[I, U.value]])], 512), [[ye, s(_).searchToggle]]), r(s(Re), null, { optLeft: n(() => [d((p(), j(F, { disabled: !s(_).selections.length, type: "primary", onClick: e[3] || (e[3] = (a) => h.value = true) }, { default: n(() => e[8] || (e[8] = [g(" 任务下发 ")])), _: 1, __: [8] }, 8, ["disabled"])), [[ge, s(_).permission.add]])]), viewLeft: n(() => [r(N, { effect: "plain", size: "large", style: { "margin-right": "6px" } }, { default: n(() => [d(f("span", null, null, 512), [[_e, { project: m.project }], [ve]])]), _: 1 }), d((p(), j(N, { type: "success", effect: "plain", size: "large", style: { "margin-right": "6px" } }, { default: n(() => {
      var a;
      return [e[9] || (e[9] = g(" 当前批次量：")), d(f("span", null, null, 512), [[A, { val: s(l).planIds.length && ((a = C.value) == null ? void 0 : a.planLength) || 0, dp: s(S).MES_ENCLOSURE_L__M }]]), e[10] || (e[10] = g("m "))];
    }), _: 1, __: [9, 10] })), [[I, V.value]]), d((p(), j(N, { type: "success", effect: "plain", size: "large" }, { default: n(() => {
      var a;
      return [e[11] || (e[11] = g(" 全部批次量：")), d(f("span", null, null, 512), [[A, { val: ((a = C.value) == null ? void 0 : a.projectLength) || 0, dp: s(S).MES_ENCLOSURE_L__M }]]), e[12] || (e[12] = g("m "))];
    }), _: 1, __: [11, 12] })), [[I, V.value]])]), _: 1 }), r(pe, { title: "任务下发", modelValue: h.value, "onUpdate:modelValue": e[6] || (e[6] = (a) => h.value = a), "before-close": () => {
      h.value = false;
    }, "close-on-click-modal": false, width: "540px" }, { titleRight: n(() => [r(F, { loading: M.value, size: "default", type: "primary", onClick: ue }, { default: n(() => e[13] || (e[13] = [g(" 保存 ")])), _: 1, __: [13] }, 8, ["loading"])]), default: n(() => [r(me, { ref_key: "formRef", ref: Q, model: c.value, rules: oe, size: "default", "label-width": "170px" }, { default: n(() => [r(x, { label: "围护种类" }, { default: n(() => {
      var a;
      return [f("span", null, R((a = s(B).VL) == null ? void 0 : a[s(l).category]), 1)];
    }), _: 1 }), r(x, { label: "总量（m）" }, { default: n(() => [f("span", null, R(ae.value), 1)]), _: 1 }), r(x, { label: "工厂/车间/生产线/班组", prop: "teamId" }, { default: n(() => [r(de, { modelValue: c.value.teamId, "onUpdate:modelValue": e[4] || (e[4] = (a) => c.value.teamId = a), options: s(Z), props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, style: { width: "300px" }, filterable: "", clearable: "", placeholder: "请选择生产组" }, null, 8, ["modelValue", "options"])]), _: 1 }), r(x, { label: "完成时间", prop: "askCompleteTime" }, { default: n(() => [r(ce, { modelValue: c.value.askCompleteTime, "onUpdate:modelValue": e[5] || (e[5] = (a) => c.value.askCompleteTime = a), "disabled-date": ie, type: "date", "value-format": "x", placeholder: "选择完成时间", style: { width: "300px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["modelValue", "before-close"])]);
  };
} }, $e = Ne(Fe, [["__scopeId", "data-v-6bda7c49"]]);
export {
  $e as default
};
