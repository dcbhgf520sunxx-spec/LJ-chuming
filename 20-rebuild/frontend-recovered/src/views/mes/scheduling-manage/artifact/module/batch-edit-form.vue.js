import { inject as y } from "vue";
import { computed as v } from "vue";
import { ref as C } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as P } from "vue";
import { createBlock as F } from "vue";
import { withCtx as r } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as c } from "vue";
import { toDisplayString as _ } from "vue";
import { createTextVNode as W } from "vue";
import { unref as p } from "vue";
import { isRef as J } from "vue";
import { ElNotification as K } from "element-plus";
import { ElTag as X } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElCascader as Z } from "element-plus";
import { v as ee } from "../../../../../modules/artifact-f1b0ca44.js";
import { u as te, o as ae, aw as oe } from "../../../../../shared/runtime.js";
import { u as le } from "../../../../../modules/use-scheduling-line-f234c58c.js";
const ue = { __name: "batch-edit-form", props: { visible: { type: Boolean, default: false }, selections: { type: Array, default: () => [] }, structureClassId: { type: [Array, Number, String, void 0] }, artName: { type: [Array, String] } }, emits: ["update:visible", "refresh"], setup(V, { emit: N }) {
  const I = N, u = V, { visible: m, handleClose: x } = te({ emit: I, props: u, field: "visible", showHook: S }), G = y("areaIdObj", {}), Q = y("curFactoryIds", []), k = y("productType"), T = v(() => ({ productType: k, structureClassId: u.structureClassId, artName: u.artName })), { groupsTree: B, groupsObj: L } = le({ queryParams: T, factoryIds: Q, disabledIds: v(() => {
    var t, e;
    return [(e = (t = u.itemInfo) == null ? void 0 : t.productionLine) == null ? void 0 : e.id];
  }) }), R = { editQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], curGroupsId: [{ required: true, message: "请选择生产线", trigger: "change" }] }, U = /* @__PURE__ */ new Map([["curGroupsId", "同上"]]), { tableValidate: H, cleanUpData: j, wrongCellMask: M } = oe({ rules: R, ditto: U }), { maxHeight: q } = ae({ mainBox: ".artifact-scheduling-batch-edit", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, m), A = v(() => {
    var e, d, n;
    const t = (e = u.selections) != null && e.length ? u.selections[0] : {};
    return `${(d = t.workshop) == null ? void 0 : d.name}>${(n = t.productionLine) == null ? void 0 : n.name}`;
  }), w = C(false), s = C([]);
  function E({ row: t, column: e, rowIndex: d, columnIndex: n }) {
    var o;
    if (n === 8) return { rowspan: ((o = s.value) == null ? void 0 : o.length) || 0, colspan: 1 };
  }
  function S() {
    s.value = u.selections.map((t, e) => ({ ...t, curGroupsId: e === 0 ? void 0 : "同上", editQuantity: t.schedulingQuantity }));
  }
  const $ = (t) => {
    s.value = s.value.map((e) => (e.id === t.id && (e.curGroupsId = t.curGroupsId), e));
  }, z = (t) => {
    s.value = s.value.map((e) => (e.id === t.id && (e.editQuantity = t.editQuantity), e));
  };
  async function O() {
    try {
      const { validResult: t, dealList: e } = H(s.value);
      if (t) {
        w.value = true, j(e);
        const d = e.map((n) => {
          var o, f, h, g;
          return { id: n.id, quantity: n.editQuantity, productionLineId: n.curGroupsId, factoryId: (f = G.value[(o = n.area) == null ? void 0 : o.id]) == null ? void 0 : f.factoryId, workshopId: (g = (h = L.value[n.curGroupsId]) == null ? void 0 : h.workshop) == null ? void 0 : g.id };
        });
        await ee(d), x(), K({ title: "批量重新分配成功", type: "success", duration: 2500 }), I("refresh");
      }
    } catch (t) {
      console.log("批量重新分配", t);
    } finally {
      w.value = false;
    }
  }
  return (t, e) => {
    const d = X, n = b("common-button"), o = Y, f = b("common-input-number"), h = Z, g = b("common-table"), D = b("common-dialog");
    return P(), F(D, { title: "批量重新分配", customClass: "artifact-scheduling-batch-edit", top: "10vh", modelValue: p(m), "onUpdate:modelValue": e[0] || (e[0] = (a) => J(m) ? m.value = a : null), width: "1400px", "before-close": p(x) }, { titleAfter: r(() => [l(d, { size: "default", effect: "plain" }, { default: r(() => [e[1] || (e[1] = c("span", null, "原产线：", -1)), c("span", null, _(A.value), 1)]), _: 1, __: [1] })]), titleRight: r(() => [l(n, { loading: w.value, type: "primary", size: "default", onClick: O }, { default: r(() => e[2] || (e[2] = [W("确 认")])), _: 1, __: [2] }, 8, ["loading"])]), default: r(() => [l(g, { data: s.value, "span-method": E, "cell-class-name": p(M), "max-height": p(q), style: { width: "100%" } }, { default: r(() => [l(o, { label: "序号", type: "index", align: "center", width: "60" }), l(o, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100", align: "center" }, { default: r(({ row: a }) => {
      var i;
      return [c("span", null, _((i = a.monomer) == null ? void 0 : i.name), 1)];
    }), _: 1 }), l(o, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100", align: "center" }, { default: r(({ row: a }) => {
      var i;
      return [c("span", null, _((i = a.area) == null ? void 0 : i.name), 1)];
    }), _: 1 }), l(o, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: r(({ row: a }) => [c("span", null, _(a.serialNumber), 1)]), _: 1 }), l(o, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), l(o, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), l(o, { prop: "editQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: r(({ row: a }) => [l(f, { modelValue: a.editQuantity, "onUpdate:modelValue": (i) => a.editQuantity = i, step: 1, min: 1, max: a.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" }, disabled: a.schedulingQuantity === 1, onChange: (i) => z(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "max", "disabled", "onChange"])]), _: 1 }), l(o, { prop: "schedulingTotalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "90", align: "center" }), l(o, { prop: "curGroupsId", "show-overflow-tooltip": true, label: "选择生产线", "min-width": "150", align: "center" }, { default: r(({ row: { sourceRow: a } }) => [l(h, { modelValue: a.curGroupsId, "onUpdate:modelValue": (i) => a.curGroupsId = i, options: p(B), "popper-class": "group-cascader", props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, filterable: "", clearable: "", style: { width: "100%" }, placeholder: "请选择现生产线", onChange: (i) => $(a) }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "onChange"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ue as default
};
