import { ref as g } from "vue";
import { inject as F } from "vue";
import { resolveComponent as U } from "vue";
import { resolveDirective as re } from "vue";
import { openBlock as p } from "vue";
import { createBlock as d } from "vue";
import { withCtx as n } from "vue";
import { unref as o } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as w } from "vue";
import { createCommentVNode as b } from "vue";
import { withDirectives as G } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as i } from "vue";
import { withKeys as K } from "vue";
import { withModifiers as O } from "vue";
import { isRef as ue } from "vue";
import { ElMessage as pe } from "element-plus";
import { ElTag as de } from "element-plus";
import { ElInput as ce } from "element-plus";
import { ElTableColumn as me } from "element-plus";
import { ElInputNumber as fe } from "element-plus";
import { ElCascader as ye } from "element-plus";
import { vLoading as ge } from "element-plus";
import { d as be } from "../../../../../../modules/productionLine-assistance-4576379e.js";
import { _ as we, u as _e, o as ve, ce as m, aw as he, c9 as Te } from "../../../../../../shared/runtime.js";
import { m as J } from "../../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
import ke from "./assistance-preview.vue.js";
import "../../../../../../modules/box-3fab54f9.js";
const Ve = { class: "head-container" }, Ie = { __name: "assistance-drawer", props: { visible: { type: Boolean, default: false }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(T, { emit: W }) {
  const D = g(), z = W, _ = T, { visible: A, handleClose: B } = _e({ emit: z, props: _, field: "visible", showHook: Q }), { maxHeight: X } = ve({ extraBox: [".el-drawer__header", ".tip", ".head-container"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true }, D), Y = g([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), r = F("crud"), Z = F("permission"), v = g({}), M = g([]), H = g(false), k = g({}), L = g([]), j = g([]), P = g(false), $ = { editQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }, { pattern: Te, message: "数量必须大于0", trigger: "blur" }], groupsId: [{ required: true, message: "请选择生产组", trigger: "change" }] }, ee = /* @__PURE__ */ new Map([["groupsId", "同上"], ["askCompleteTime", "同上"]]), { tableValidate: te, cleanUpData: ae, wrongCellMask: oe } = he({ rules: $, ditto: ee });
  function Q() {
    v.value = {}, C();
  }
  function le(f) {
    L.value = f;
  }
  function se(f, a, c) {
    c !== 0 && !f && (a.groupsId = "同上");
  }
  async function C() {
    var f, a, c, y, u, l, E, x, N, R, q;
    try {
      H.value = true, M.value = [], k.value = {};
      const { content: h } = await be({ taskOrderId: (f = _.info) == null ? void 0 : f.id, ...v.value });
      for (let e = 0; e < h.length; e++) {
        const t = h[e];
        if (t.attributeType = t.taskTypeEnum === m.CELL.V ? "单元件" : "套料", t.editQuantity = t.quantity, !k.value[t.configId]) {
          let s = {};
          r.query.taskTypeEnum === m.MACHINE_PART.V ? s = await J({ productType: r.query.taskTypeEnum, disabledIds: ((a = t == null ? void 0 : t.groups) == null ? void 0 : a.id) && [(c = t == null ? void 0 : t.groups) == null ? void 0 : c.id] || [] }) : s = await J({ productType: r.query.taskTypeEnum, boxClassId: t.configId, disabledIds: ((u = (y = _.info) == null ? void 0 : y.groups) == null ? void 0 : u.id) && [(E = (l = _.info) == null ? void 0 : l.groups) == null ? void 0 : E.id] || [], _factoryIds: ((N = (x = _.info) == null ? void 0 : x.factory) == null ? void 0 : N.id) && [(q = (R = _.info) == null ? void 0 : R.factory) == null ? void 0 : q.id] || [] }), k.value[t.configId] = s;
        }
        e > 0 && (t.groupsId = "同上"), M.value.push(t);
      }
    } catch (h) {
      console.log("可变更的任务工单详情列表获取失败", h);
    } finally {
      H.value = false;
    }
  }
  function ne() {
    var y;
    if (!((y = L.value) != null && y.length)) {
      pe.warning("请至少选择一条数据");
      return;
    }
    const f = L.value.map((u) => u), { validResult: a, dealList: c } = te(f);
    if (a) ae(c), j.value = c.map((u, l) => ({ ...u, assistance: { ...k.value[u.configId].obj[u.groupsId] } }));
    else return a;
    P.value = true;
  }
  function ie() {
    B(), z("success");
  }
  return (f, a) => {
    const c = de, y = U("common-button"), u = ce, l = me, E = fe, x = ye, N = U("common-table"), R = U("common-drawer"), q = re("permission"), h = ge;
    return p(), d(R, { ref_key: "drawerRef", ref: D, title: "产线协同", modelValue: o(A), "onUpdate:modelValue": a[3] || (a[3] = (e) => ue(A) ? A.value = e : null), direction: "rtl", "before-close": o(B), size: "80%" }, { titleAfter: n(() => [o(r).query.taskTypeEnum !== o(m).MACHINE_PART.V ? (p(), d(c, { key: 0, effect: "plain" }, { default: n(() => {
      var e, t, s;
      return [V(" 原生产组：" + w((e = T.info.workshop) == null ? void 0 : e.name) + ">" + w((t = T.info.productionLine) == null ? void 0 : t.name) + ">" + w((s = T.info.groups) == null ? void 0 : s.name), 1)];
    }), _: 1 })) : b("", true)]), titleRight: n(() => [G((p(), d(y, { size: "default", type: "primary", onClick: ne }, { default: n(() => a[4] || (a[4] = [V("预览并保存")])), _: 1, __: [4] })), [[q, o(Z).save]])]), content: n(() => [a[7] || (a[7] = I("div", { class: "tip" }, [I("span", null, "* 提示："), I("span", null, " 产线协同只能对未开始生产的分段或单元件或零件进行协同，已经开始生产无法协同")], -1)), I("div", Ve, [i(u, { modelValue: v.value.serialNumber, "onUpdate:modelValue": a[0] || (a[0] = (e) => v.value.serialNumber = e), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: K(C, ["enter"]) }, null, 8, ["modelValue"]), i(u, { modelValue: v.value.specification, "onUpdate:modelValue": a[1] || (a[1] = (e) => v.value.specification = e), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "", onKeyup: K(C, ["enter"]) }, null, 8, ["modelValue"]), i(y, { class: "filter-item", size: "default", type: "success", icon: "el-icon-search", onClick: O(C, ["stop"]) }, { default: n(() => a[5] || (a[5] = [V("搜索")])), _: 1, __: [5] }), i(y, { class: "filter-item", size: "default", type: "warning", icon: "el-icon-refresh-left", onClick: O(Q, ["stop"]) }, { default: n(() => a[6] || (a[6] = [V(" 重置 ")])), _: 1, __: [6] })]), G((p(), d(N, { data: M.value, "max-height": o(X), "cell-class-name": o(oe), "data-format": Y.value, onSelectionChange: le, style: { width: "100%" } }, { default: n(() => [i(l, { type: "selection", width: "55", align: "center" }), i(l, { label: "序号", type: "index", align: "center", width: "60" }), o(r).query.taskTypeEnum !== o(m).MACHINE_PART.V ? (p(), d(l, { key: 0, prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100px", align: "center" })) : b("", true), o(r).query.taskTypeEnum === o(m).MACHINE_PART.V ? (p(), d(l, { key: 1, prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "100px", align: "center" })) : b("", true), o(r).query.taskTypeEnum === o(m).CELL.V ? (p(), d(l, { key: 2, prop: "attributeType", "show-overflow-tooltip": true, label: "属性", width: "90", align: "center" }, { default: n(({ row: e }) => [i(c, { type: e.attributeType === "单元件" ? "warning" : "success" }, { default: n(() => [V(w(e.attributeType), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })) : b("", true), o(r).query.taskTypeEnum !== o(m).MACHINE_PART.V ? (p(), d(l, { key: 3, prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100px", align: "center" })) : b("", true), i(l, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "100px", align: "center" }), o(r).query.taskTypeEnum !== o(m).MACHINE_PART.V ? (p(), d(l, { key: 4, prop: "length", "show-overflow-tooltip": true, label: "长度(mm)", width: "100px", align: "center" })) : b("", true), i(l, { "show-overflow-tooltip": true, label: "协同数量", "min-width": "100px", align: "center" }, { default: n(({ row: { sourceRow: e } }) => [i(E, { modelValue: e.editQuantity, "onUpdate:modelValue": (t) => e.editQuantity = t, step: 1, min: 1, max: e.quantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), o(r).query.taskTypeEnum === o(m).MACHINE_PART.V ? (p(), d(l, { key: 5, align: "center", prop: "askCompleteTime", "show-overflow-tooltip": true, label: "计划完成日期", width: "120px" })) : b("", true), o(r).query.taskTypeEnum === o(m).MACHINE_PART.V ? (p(), d(l, { key: 6, prop: "group.name", "show-overflow-tooltip": true, label: "原生产组", "min-width": "180px" }, { default: n(({ row: e }) => {
      var t, s, S;
      return [I("span", null, w((t = e.workshop) == null ? void 0 : t.name) + ">" + w((s = e.productionLine) == null ? void 0 : s.name) + ">" + w((S = e.groups) == null ? void 0 : S.name), 1)];
    }), _: 1 })) : b("", true), i(l, { "show-overflow-tooltip": true, prop: "groupsId", label: "生产组", "min-width": "150px", align: "center" }, { default: n(({ row: { sourceRow: e }, $index: t }) => [i(x, { modelValue: e.groupsId, "onUpdate:modelValue": (s) => e.groupsId = s, options: k.value[e.configId].list, props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": "", filterable: "", clearable: "", placeholder: t === 0 ? "请选择生产组" : "同上", style: { width: "100%" }, onChange: (s) => se(s, e, t) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "placeholder", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "cell-class-name", "data-format"])), [[h, H.value]]), i(o(ke), { visible: P.value, "onUpdate:visible": a[2] || (a[2] = (e) => P.value = e), info: T.info, list: j.value, onSuccess: ie }, null, 8, ["visible", "info", "list"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, Ae = we(Ie, [["__scopeId", "data-v-706c69cc"]]);
export {
  Ae as default
};
