import { ref as m } from "vue";
import { inject as q } from "vue";
import { watch as A } from "vue";
import { resolveComponent as G } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as w } from "vue";
import { withDirectives as V } from "vue";
import { vShow as L } from "vue";
import { unref as a } from "vue";
import { createElementVNode as j } from "vue";
import { createVNode as n } from "vue";
import { normalizeStyle as D } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as v } from "vue";
import { Fragment as O } from "vue";
import { renderList as Q } from "vue";
import { createBlock as y } from "vue";
import { toDisplayString as g } from "vue";
import { ElRadioGroup as H } from "element-plus";
import { ElRadioButton as K } from "element-plus";
import { ElInput as M } from "element-plus";
import { ElTag as P } from "element-plus";
import { vLoading as $ } from "element-plus";
import { s as F, d as J } from "../../../../../modules/artifact-bbca1257.js";
import { tw as X, B as Y, G as Z, q as ee, m8 as ae, C as le, L as te, E as oe } from "../../../../../shared/runtime.js";
import { a as ne } from "../../../../../modules/index-8356a01a.js";
const de = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, setup(N) {
  const _ = N, C = { name: "", batchNumber: "", serialNumber: "", specification: "", material: "", monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, status: { value: void 0, resetAble: false }, permissionCheck: X.CHECK_PERMISSION.V, areaBatchId: void 0 }, k = m(), x = m({}), i = m([]), h = m({}), o = m({ loading: false, quantity: 0, totalNetWeight: 0, totalGrossWeight: 0 }), u = m([]), b = q("permission"), { crud: c, query: l, CRUD: S } = Y(C);
  S.HOOK.handleRefresh = (s, e) => {
    U();
  }, A([() => l.areaId, () => i.value], (s) => {
    var e;
    s && (i.value.length > 0 ? (u.value = (e = i.value.filter((r) => r.id + "" == l.areaId + "")[0]) == null ? void 0 : e.planAreaBatchDTOS, h.value = { id: u.value ? u.value[0].id + "" : "", name: u.value ? u.value[0].name : "" }) : (h.value = {}, u.value = []));
  }, { immediate: true, deep: true });
  async function U() {
    if (o.value.quantity = 0, o.value.totalNetWeight = 0, o.value.totalGrossWeight = 0, !(!Z(b.get) || !l.areaId)) {
      o.value.loading = true;
      try {
        const { quantity: s = 0, totalNetWeight: e = 0, totalGrossWeight: r = 0 } = await F(l) || {};
        o.value.quantity = s, o.value.totalNetWeight = e, o.value.totalGrossWeight = r;
      } catch (s) {
        console.log("获取构件清单汇总数据", s);
      } finally {
        o.value.loading = false;
      }
    }
  }
  function B(s) {
    const { name: e, label: r } = s;
    x.value = { id: e, name: r }, c.toQuery();
  }
  function E(s) {
    var e;
    i.value = s.filter((r) => r.itemizedType === 1) || [], l.areaId = (e = i.value[0]) == null ? void 0 : e.id;
  }
  return (s, e) => {
    const r = G("common-select"), I = K, f = M, W = P, z = R("permission"), T = $;
    return p(), w("div", null, [V(j("div", null, [n(a(ee), { ref_key: "monomerSelectRef", ref: k, modelValue: a(l).monomerId, "onUpdate:modelValue": e[0] || (e[0] = (t) => a(l).monomerId = t), "project-id": _.projectId, class: "filter-item", onGetAreaInfo: E, "show-tips": i.value.length <= 0 }, null, 8, ["modelValue", "project-id", "show-tips"]), n(r, { modelValue: a(l).areaId, "onUpdate:modelValue": e[1] || (e[1] = (t) => a(l).areaId = t), options: i.value, type: "other", dataStructure: { key: "id", label: "name", value: "id" }, placeholder: "请选择区域", class: "filter-item", style: { width: "200px", "margin-left": "3px" }, onChange: a(c).toQuery }, null, 8, ["modelValue", "options", "onChange"]), n(a(ne), { modelValue: a(l).areaBatchId, "onUpdate:modelValue": e[2] || (e[2] = (t) => a(l).areaBatchId = t), "area-info": u.value, "default-tab": h.value, style: D(i.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: B }, null, 8, ["modelValue", "area-info", "default-tab", "style"]), n(a(H), { modelValue: a(l).status, "onUpdate:modelValue": e[3] || (e[3] = (t) => a(l).status = t), class: "filter-item", size: "default", onChange: a(c).toQuery }, { default: d(() => [n(I, { value: void 0 }, { default: d(() => e[9] || (e[9] = [v("全部")])), _: 1, __: [9] }), (p(true), w(O, null, Q(a(ae).ENUM, (t) => (p(), y(I, { key: t.V, value: t.V }, { default: d(() => [v(g(t.L), 1)]), _: 2 }, 1032, ["value"]))), 128))]), _: 1 }, 8, ["modelValue", "onChange"]), n(f, { modelValue: a(l).batchNumber, "onUpdate:modelValue": e[4] || (e[4] = (t) => a(l).batchNumber = t), class: "filter-item", clearable: "", placeholder: "输入批次搜索", size: "default", style: { width: "170px", "margin-left": "0" } }, null, 8, ["modelValue"]), n(f, { modelValue: a(l).name, "onUpdate:modelValue": e[5] || (e[5] = (t) => a(l).name = t), class: "filter-item", clearable: "", placeholder: "输入名称搜索", size: "default", style: { width: "170px", "margin-left": "0" } }, null, 8, ["modelValue"]), n(f, { modelValue: a(l).serialNumber, "onUpdate:modelValue": e[6] || (e[6] = (t) => a(l).serialNumber = t), class: "filter-item", clearable: "", placeholder: "输入编号搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(f, { modelValue: a(l).specification, "onUpdate:modelValue": e[7] || (e[7] = (t) => a(l).specification = t), class: "filter-item", clearable: "", placeholder: "输入规格搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(f, { modelValue: a(l).material, "onUpdate:modelValue": e[8] || (e[8] = (t) => a(l).material = t), class: "filter-item", clearable: "", placeholder: "输入材质搜索", size: "default", style: { width: "170px" } }, null, 8, ["modelValue"]), n(a(le))], 512), [[L, a(c).searchToggle]]), n(a(oe), null, { optLeft: d(() => [V((p(), y(te, { params: a(l), fn: a(J) }, { default: d(() => e[10] || (e[10] = [v(" 构件清单（根据查询条件） ")])), _: 1, __: [10] }, 8, ["params", "fn"])), [[z, a(b).download]])]), viewLeft: d(() => [V((p(), y(W, { effect: "plain", size: "large" }, { default: d(() => [v(" 构件清单量合计（数量/总净重/总毛重）：" + g(o.value.quantity) + "件 / " + g(o.value.totalNetWeight) + "kg / " + g(o.value.totalGrossWeight) + "kg ", 1)]), _: 1 })), [[T, o.value.loading]])]), _: 1 })]);
  };
} };
export {
  de as default
};
