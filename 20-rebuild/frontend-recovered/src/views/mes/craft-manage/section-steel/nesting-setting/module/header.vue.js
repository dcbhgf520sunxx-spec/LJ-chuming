import { ref as d } from "vue";
import { computed as X } from "vue";
import { watchEffect as Y } from "vue";
import { resolveComponent as T } from "vue";
import { resolveDirective as ee } from "vue";
import { openBlock as b } from "vue";
import { createElementBlock as le } from "vue";
import { withDirectives as g } from "vue";
import { vShow as k } from "vue";
import { unref as l } from "vue";
import { createElementVNode as $ } from "vue";
import { createVNode as n } from "vue";
import { withCtx as r } from "vue";
import { createBlock as v } from "vue";
import { createCommentVNode as I } from "vue";
import { createTextVNode as h } from "vue";
import { withKeys as te } from "vue";
import { renderSlot as ae } from "vue";
import { Fragment as oe } from "vue";
import { ElMessage as ne } from "element-plus";
import { ElMessageBox as ie } from "element-plus";
import { ElNotification as se } from "element-plus";
import { ElFormItem as re } from "element-plus";
import { ElForm as ue } from "element-plus";
import { ElTag as de } from "element-plus";
import { ElInput as me } from "element-plus";
import { g as pe, s as ce } from "../../../../../../modules/nesting-setting-83aca0bd.js";
import { _ as fe, ns as A, B as be, aU as V, bZ as ye, ng as ge, nt as ve, C as Ie, nr as L, E as Ve } from "../../../../../../shared/runtime.js";
import _e from "./no-nesting-drawer.vue.js";
import Ce from "./extrusion-nesting-setting.vue.js";
import "../../../../../../modules/popover-confirm-35927771.js";
import "./nesting-progress.vue.js";
const Ne = { __name: "header", emits: ["change-mode"], setup(Te, { emit: Q }) {
  const B = Q, O = { projectId: { value: void 0, resetAble: false }, monomerId: { value: void 0, resetAble: false }, ids: { value: [], resetAble: false }, structureClassId: void 0, specPrefix: void 0, boolMainAssemble: A.MAIN_ASSEMBLE.V }, { crud: s, query: t } = be(O), x = d(false), E = d(false), q = d({}), p = d("nesting"), c = d({}), _ = d([]), y = d([]), w = d([]), U = d([]), f = X(() => t.productionLineTypeEnum === V.TRADITION.V), R = d([{ type: "nesting", label: "套料模式" }, { type: "edit", label: "编辑模式" }]);
  Y(() => {
    var i, e, u;
    f.value ? (_.value = [], y.value = c.value[V.TRADITION.V] && ((e = (i = c.value[V.TRADITION.V][0]) == null ? void 0 : i.assemblePropertyDTOS) == null ? void 0 : e.map((a) => (a.label = `【${a.specPrefix}】${a.name}`, a))) || []) : (_.value = ((u = c.value[V.INTELLECT.V]) == null ? void 0 : u.map((a) => (a.id = a.ids.join(","), a.structureNameDTOS.map((m) => {
      a.label = a.label ? a.label + ` -【${m.definitionWord}】${m.classificationName}` : `【${m.definitionWord}】${m.classificationName}`;
    }), a))) || [], y.value = []);
  });
  function z() {
    t.areaIds = t.ids ? t.ids.join(",") : void 0, C(), t.productionLineTypeEnum = V.TRADITION.V, s.toQuery();
  }
  function F(i) {
    t.structureClassId = void 0, t.specPrefix = void 0, t.specification = void 0, t.material = void 0, t.boolMainAssemble = A.MAIN_ASSEMBLE.V, f.value || (p.value = "nesting", P(p.value)), C();
  }
  async function C() {
    if (c.value = {}, !(!t.projectId || !t.monomerId)) try {
      c.value = {};
      const i = await pe({ projectId: t.projectId, monomerId: t.monomerId, areaIds: t.ids ? t.ids.join(",") : void 0 });
      c.value = i, s.toQuery();
    } catch (i) {
      console.log(i, "获取其它筛选条件列表");
    }
  }
  function K(i) {
    var e, u;
    y.value = ((u = (e = _.value.find((a) => a.id === i)) == null ? void 0 : e.assemblePropertyDTOS) == null ? void 0 : u.map((a) => (a.label = `【${a.specPrefix}】${a.name}`, a))) || [], s.toQuery();
  }
  function H(i) {
    var e;
    w.value = ((e = y.value.find((u) => u.specPrefix === i)) == null ? void 0 : e.specificationList) || [], s.toQuery();
  }
  function W(i) {
    var e, u;
    U.value = ((u = (e = w.value.find((a) => a.specification === i)) == null ? void 0 : e.material) == null ? void 0 : u.map((a) => ({ material: a }))) || [], s.toQuery();
  }
  function P(i) {
    B("change-mode", i);
  }
  async function Z() {
    var i;
    if (!((i = s.selections) != null && i.length)) {
      ne.warning("请至少选择一条数据");
      return;
    }
    try {
      ie.confirm("是否确认将所选的数据移入【无需套料清单】内", "提示", { confirmButtonText: "确认", cancelButtonText: "取消", type: "warning" }).then(async () => {
        try {
          const e = s.selections.map((u) => ({ assembleDetailId: u.assembleDetailId, quantity: u.editQuantity }));
          await ce(e), se({ title: "移入成功", type: "success", duration: 2500 }), s.toQuery();
        } catch (e) {
          console.log("无需套料设置失败", e);
        }
      });
    } catch (e) {
      console.log(e, "无需套料设置失败");
    }
  }
  function G(i) {
    E.value = true, q.value = i;
  }
  return (i, e) => {
    const u = T("project-cascader"), a = re, m = T("common-radio-button"), S = ue, N = T("common-select"), J = de, D = me, M = T("common-button"), j = ee("permission");
    return b(), le(oe, null, [g($("div", null, [n(S, { style: { display: "flex", "flex-wrap": "wrap" } }, { default: r(() => [n(a, { label: "所属项目", class: "form-label-require" }, { default: r(() => [n(u, { modelValue: l(t).projectId, "onUpdate:modelValue": e[0] || (e[0] = (o) => l(t).projectId = o), placeholder: "所属项目", clearable: "", class: "filter-item", style: { width: "300px" }, onChange: C }, null, 8, ["modelValue"])]), _: 1 }), n(a, { label: "项目单体", class: "form-label-require" }, { default: r(() => [n(l(ye), { monomerId: l(t).monomerId, "onUpdate:monomerId": e[1] || (e[1] = (o) => l(t).monomerId = o), areaId: l(t).ids, "onUpdate:areaId": e[2] || (e[2] = (o) => l(t).ids = o), clearable: "", areaClearable: "", areaMultiple: "", productType: l(ge).STRUCTURE.V, "project-id": l(t).projectId, onMonomerChange: C, onAreaChange: z }, null, 8, ["monomerId", "areaId", "productType", "project-id"])]), _: 1 }), n(a, { label: "生产模式", class: "form-label-require" }, { default: r(() => [n(m, { modelValue: l(t).productionLineTypeEnum, "onUpdate:modelValue": e[3] || (e[3] = (o) => l(t).productionLineTypeEnum = o), options: l(ve).ENUM, type: "enum", default: "", class: "filter-item", onChange: F }, null, 8, ["modelValue", "options"])]), _: 1 }), n(a, { class: "form-label-require" }, { default: r(() => [f.value ? I("", true) : (b(), v(m, { key: 0, modelValue: l(t).boolMainAssemble, "onUpdate:modelValue": e[4] || (e[4] = (o) => l(t).boolMainAssemble = o), options: l(A).ENUM, type: "enum", class: "filter-item", onChange: l(s).toQuery }, null, 8, ["modelValue", "options", "onChange"]))]), _: 1 })]), _: 1 }), n(S, { style: { display: "flex", "flex-wrap": "wrap" } }, { default: r(() => [n(a, { label: "生产类型", class: "form-label-require" }, { default: r(() => [n(N, { modelValue: l(t).structureClassId, "onUpdate:modelValue": e[5] || (e[5] = (o) => l(t).structureClassId = o), options: _.value, disabled: f.value, type: "other", "data-structure": { key: "id", label: "label", value: "id" }, class: "filter-item", clearable: "", style: { width: "300px" }, placeholder: "请选择生产类型", onChange: K }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), n(a, { label: "部件类型", class: "form-label-require" }, { default: r(() => [n(N, { modelValue: l(t).specPrefix, "onUpdate:modelValue": e[6] || (e[6] = (o) => l(t).specPrefix = o), options: y.value, type: "other", "data-structure": { key: "specPrefix", label: "label", value: "specPrefix" }, class: "filter-item", clearable: "", style: { width: "200px" }, placeholder: "请选择部件类型", onChange: H }, null, 8, ["modelValue", "options"])]), _: 1 }), n(a, { label: "规格筛选" }, { default: r(() => [n(N, { modelValue: l(t).specification, "onUpdate:modelValue": e[7] || (e[7] = (o) => l(t).specification = o), options: w.value, type: "other", clearable: "", "data-structure": { key: "specification", label: "specification", value: "specification" }, class: "filter-item", style: { width: "200px" }, placeholder: "请选择规格", onChange: W }, null, 8, ["modelValue", "options"])]), _: 1 }), n(a, { label: "材质筛选" }, { default: r(() => [n(N, { modelValue: l(t).material, "onUpdate:modelValue": e[8] || (e[8] = (o) => l(t).material = o), options: U.value, type: "other", clearable: "", "data-structure": { key: "material", label: "material", value: "material" }, class: "filter-item", style: { width: "200px" }, placeholder: "请选择材质", onChange: l(s).toQuery }, null, 8, ["modelValue", "options", "onChange"])]), _: 1 })]), _: 1 })], 512), [[k, l(s).searchToggle]]), g($("div", null, [n(J, { effect: "plain", size: "large", class: "filter-item" }, { default: r(() => e[15] || (e[15] = [h("长度≥：")])), _: 1, __: [15] }), n(D, { type: "number", modelValue: l(t).length, "onUpdate:modelValue": e[9] || (e[9] = (o) => l(t).length = o), modelModifiers: { trim: true }, class: "filter-item", size: "default", placeholder: "输入长度搜索", style: { width: "117px" } }, null, 8, ["modelValue"]), n(D, { modelValue: l(t).serialNumber, "onUpdate:modelValue": e[10] || (e[10] = (o) => l(t).serialNumber = o), modelModifiers: { trim: true }, size: "default", placeholder: "输入编号搜索", style: { width: "200px" }, class: "filter-item", clearable: "", onKeyup: te(l(s).toQuery, ["enter"]) }, null, 8, ["modelValue", "onKeyup"]), n(l(Ie))], 512), [[k, l(s).searchToggle]]), n(l(Ve), null, { optLeft: r(() => [f.value ? (b(), v(m, { key: 0, modelValue: p.value, "onUpdate:modelValue": e[11] || (e[11] = (o) => p.value = o), options: R.value, dataStructure: { key: "type", label: "label", value: "type" }, type: "other", class: "filter-item", onChange: P }, null, 8, ["modelValue", "options"])) : I("", true), p.value === "nesting" ? g((b(), v(M, { key: 1, class: "filter-item", type: "success", size: "default", icon: "el-icon-menu", disabled: l(s).selections.length === 0, onClick: G }, { default: r(() => e[16] || (e[16] = [h(" 型材套排 ")])), _: 1, __: [16] }, 8, ["disabled"])), [[j, l(L).extrusionNestingDetail]]) : I("", true), p.value === "edit" ? g((b(), v(M, { key: 2, class: "filter-item", type: "warning", size: "default", icon: "el-icon-setting", onClick: Z }, { default: r(() => e[17] || (e[17] = [h(" 移入【无需套料清单】 ")])), _: 1, __: [17] })), [[j, l(L).noNesting]]) : I("", true)]), viewLeft: r(() => [ae(i.$slots, "viewLeft", {}, void 0, true), f.value ? g((b(), v(M, { key: 0, disabled: !l(t).projectId, class: "filter-item", type: "success", size: "default", icon: "el-icon-view", onClick: e[12] || (e[12] = (o) => x.value = true) }, { default: r(() => e[18] || (e[18] = [h(" 查看【无需套料清单】 ")])), _: 1, __: [18] }, 8, ["disabled"])), [[j, l(L).noNestingDetail]]) : I("", true)]), _: 3 }), n(_e, { visible: x.value, "onUpdate:visible": e[13] || (e[13] = (o) => x.value = o), onRefresh: l(s).toQuery }, null, 8, ["visible", "onRefresh"]), n(Ce, { visible: E.value, "onUpdate:visible": e[14] || (e[14] = (o) => E.value = o), "detail-data": l(s).selections, monomerId: l(t).monomerId, projectId: l(t).projectId }, null, 8, ["visible", "detail-data", "monomerId", "projectId"])], 64);
  };
} }, Le = fe(Ne, [["__scopeId", "data-v-06a8a648"]]);
export {
  Le as default
};
