import { ref as c } from "vue";
import { useRouter as U } from "vue-router";
import { watch as g } from "vue";
import { resolveComponent as L } from "vue";
import { openBlock as V } from "vue";
import { createElementBlock as _ } from "vue";
import { withDirectives as q } from "vue";
import { vShow as z } from "vue";
import { unref as t } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as r } from "vue";
import { createBlock as b } from "vue";
import { withCtx as p } from "vue";
import { toDisplayString as y } from "vue";
import { createCommentVNode as I } from "vue";
import { withKeys as T } from "vue";
import { createTextVNode as E } from "vue";
import { withModifiers as Q } from "vue";
import { renderSlot as k } from "vue";
import { Fragment as A } from "vue";
import { ElInput as S } from "element-plus";
import { f as B, h as Y } from "../../../../../modules/artifact-f1b0ca44.js";
import { qt as d, B as R, es as j, bW as K, E as D } from "../../../../../shared/runtime.js";
const $ = { style: { display: "flex", "justify-content": "space-between" } }, X = { __name: "header", props: { projectId: String }, setup(F, { expose: x }) {
  const m = c();
  U();
  const P = { monomerId: void 0, areaId: void 0, productionLineType: d.TYPE.V, structureClassId: void 0, artName: void 0, specification: void 0, serialNumber: void 0, material: void 0, name: void 0 };
  c([]);
  const s = c([]), C = c([]), { crud: o, query: e } = R(P);
  g([() => e.productionLineType, () => o.query.areaIdList], () => {
    e.productionLineType === d.TYPE.V ? e.artName = void 0 : e.structureClassId = void 0, s.value = [], v();
  }, { deep: true }), g([() => e.structureClassId], () => {
    var l;
    e.structureClassId && m.value && (e.mesProductEnum = (l = m.value.getOption(e.structureClassId)) == null ? void 0 : l.mesProductEnum);
  }), g(() => e.artName, () => {
    var l;
    e.artName && m.value && (e.mesProductEnum = (l = m.value.getOption(e.artName)) == null ? void 0 : l.mesProductEnum);
  });
  function M() {
    e.name = void 0, e.serialNumber = void 0, e.specification = void 0, e.material = void 0, o.toQuery();
  }
  async function v() {
    e.structureClassId = void 0, e.artName = void 0;
    const l = e.productionLineType === d.TYPE.V ? B : Y, { content: a } = await l({ areaIdList: o.query.areaIdList });
    s.value = a.map((u) => (u.hasAngle = u.artifactType === j.SMALL.V, u)), O();
  }
  function O() {
    var l, a;
    e.productionLineType === d.TYPE.V ? e.structureClassId = (l = s.value) != null && l.length ? s.value[0].structureClassId : void 0 : e.artName = (a = s.value) != null && a.length ? s.value[0].name : void 0, o.toQuery();
  }
  return x({ refreshTypeList: v, getNameOption: (l) => {
    C.value = l.reduce((a, u) => (a.some((f) => f.name === u.name) || a.push(u), a), []);
  } }), (l, a) => {
    var h, w;
    const u = L("common-select"), f = S, N = L("common-button");
    return V(), _(A, null, [q(i("div", null, [r(u, { modelValue: t(e).productionLineType, "onUpdate:modelValue": a[0] || (a[0] = (n) => t(e).productionLineType = n), options: t(d).ENUM, size: "default", type: "enum", class: "filter-item", style: { width: "80px" }, unshowOptions: [t(d).NAME.K], onChange: t(o).toQuery }, null, 8, ["modelValue", "options", "unshowOptions", "onChange"]), t(e).productionLineType === t(d).TYPE.V && ((h = s.value) != null && h.length) ? (V(), b(t(K), { key: 0, ref_key: "tagTabsRef", ref: m, modelValue: t(e).structureClassId, "onUpdate:modelValue": a[1] || (a[1] = (n) => t(e).structureClassId = n), class: "filter-item", style: "width:calc(100% - 205px)", data: s.value, itemKey: "structureClassId", onChange: t(o).toQuery }, { default: p(({ item: n }) => [i("span", null, y(n.name) + "：", 1), i("span", null, y(n.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data", "onChange"])) : I("", true), t(e).productionLineType === t(d).NAME.V && ((w = s.value) != null && w.length) ? (V(), b(t(K), { key: 1, ref_key: "tagTabsRef", ref: m, modelValue: t(e).artName, "onUpdate:modelValue": a[2] || (a[2] = (n) => t(e).artName = n), class: "filter-item", style: "width:calc(100% - 205px)", data: s.value, itemKey: "name", onChange: t(o).toQuery }, { default: p(({ item: n }) => [i("span", null, y(n.name) + "：", 1), i("span", null, y(n.quantity) + "件", 1)]), _: 1 }, 8, ["modelValue", "data", "onChange"])) : I("", true), i("div", $, [i("div", null, [a[9] || (a[9] = i("div", null, null, -1)), r(u, { modelValue: t(e).name, "onUpdate:modelValue": a[3] || (a[3] = (n) => t(e).name = n), options: C.value, size: "default", dataStructure: { key: "name", label: "name", value: "name" }, clearable: "", class: "filter-item", placeholder: "请选择名称搜索", onChange: t(o).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(f, { modelValue: t(e).serialNumber, "onUpdate:modelValue": a[4] || (a[4] = (n) => t(e).serialNumber = n), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: T(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(f, { modelValue: t(e).specification, "onUpdate:modelValue": a[5] || (a[5] = (n) => t(e).specification = n), modelModifiers: { trim: true }, size: "default", placeholder: "输入规格搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: T(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(f, { modelValue: t(e).material, "onUpdate:modelValue": a[6] || (a[6] = (n) => t(e).material = n), modelModifiers: { trim: true }, size: "default", placeholder: "输入材质搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: T(t(o).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), r(N, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: Q(t(o).toQuery, ["stop"]) }, { default: p(() => a[7] || (a[7] = [E("搜索")])), _: 1, __: [7] }, 8, ["onClick"]), r(N, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: Q(M, ["stop"]) }, { default: p(() => a[8] || (a[8] = [E(" 重置 ")])), _: 1, __: [8] })])])], 512), [[z, t(o).searchToggle]]), r(t(D), null, { optLeft: p(() => [k(l.$slots, "optLeft")]), viewLeft: p(() => [k(l.$slots, "viewLeft")]), _: 3 })], 64);
  };
} };
export {
  X as default
};
