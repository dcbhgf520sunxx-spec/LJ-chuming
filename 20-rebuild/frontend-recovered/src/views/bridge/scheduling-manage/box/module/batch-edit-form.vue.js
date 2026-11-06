import { inject as I } from "vue";
import { computed as v } from "vue";
import { ref as k } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as A } from "vue";
import { createBlock as D } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as w } from "vue";
import { createTextVNode as P } from "vue";
import { unref as c } from "vue";
import { isRef as F } from "vue";
import { ElNotification as W } from "element-plus";
import { ElTag as J } from "element-plus";
import { ElTableColumn as K } from "element-plus";
import { ElCascader as X } from "element-plus";
import { j as Y } from "../../../../../modules/box-3fab54f9.js";
import { u as Z, o as ee, aw as te } from "../../../../../shared/runtime.js";
import { u as oe } from "../../../../../modules/use-scheduling-groups-9f6c1fa1.js";
const ie = { __name: "batch-edit-form", props: { visible: { type: Boolean, default: false }, selections: { type: Array, default: () => [] }, boxClassId: { type: [Number, String, void 0] } }, emits: ["update:visible", "refresh"], setup(G, { emit: T }) {
  const x = T, r = G, { visible: p, handleClose: V } = Z({ emit: x, props: r, field: "visible", showHook: S }), N = I("areaIdObj", {}), Q = I("curFactoryIds", []), B = I("productType"), U = v(() => ({ productType: B, boxClassId: r.boxClassId })), { groupsTree: j, groupsObj: C } = oe({ queryParams: U, factoryIds: Q, disabledIds: v(() => {
    var a, e;
    return (a = r.selections) != null && a.length ? [(e = r.selections[0].groups) == null ? void 0 : e.id] : [];
  }) }), H = { editQuantity: [{ required: true, message: "请填写数量", trigger: "blur" }], curGroupsId: [{ required: true, message: "请选择生产组", trigger: "change" }] }, L = /* @__PURE__ */ new Map([["curGroupsId", "同上"]]), { tableValidate: R, cleanUpData: M, wrongCellMask: q } = te({ rules: H, ditto: L }), { maxHeight: E } = ee({ mainBox: ".box-scheduling-batch-edit", extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, p), z = v(() => {
    var e, u, n, t;
    const a = (e = r.selections) != null && e.length ? r.selections[0] : {};
    return `${(u = a.workshop) == null ? void 0 : u.name}>${(n = a.productionLine) == null ? void 0 : n.name}>${(t = a.groups) == null ? void 0 : t.name}`;
  }), y = k(false), m = k([]);
  function O({ row: a, column: e, rowIndex: u, columnIndex: n }) {
    var t;
    if (n === 8) return { rowspan: ((t = m.value) == null ? void 0 : t.length) || 0, colspan: 1 };
  }
  function S() {
    m.value = r.selections.map((a, e) => ({ ...a, curGroupsId: e === 0 ? void 0 : "同上", editQuantity: a.schedulingQuantity }));
  }
  async function $() {
    try {
      const { validResult: a, dealList: e } = R(m.value);
      if (a) {
        y.value = true, M(e);
        const u = e.map((n) => {
          var t, f, g, h, b, o;
          return { id: n.id, quantity: n.editQuantity, groupsId: n.curGroupsId, factoryId: (f = N.value[(t = n.area) == null ? void 0 : t.id]) == null ? void 0 : f.factoryId, productionLineId: (h = (g = C[n.curGroupsId]) == null ? void 0 : g.productionLine) == null ? void 0 : h.id, workshopId: (o = (b = C[n.curGroupsId]) == null ? void 0 : b.workshop) == null ? void 0 : o.id };
        });
        await Y(u), V(), W({ title: "批量重新分配成功", type: "success", duration: 2500 }), x("refresh");
      }
    } catch (a) {
      console.log("批量重新分配", a);
    } finally {
      y.value = false;
    }
  }
  return (a, e) => {
    const u = J, n = _("common-button"), t = K, f = _("common-input-number"), g = X, h = _("common-table"), b = _("common-dialog");
    return A(), D(b, { title: "批量重新分配", customClass: "box-scheduling-batch-edit", top: "10vh", modelValue: c(p), "onUpdate:modelValue": e[0] || (e[0] = (o) => F(p) ? p.value = o : null), width: "1400px", "before-close": c(V) }, { titleAfter: s(() => [l(u, { size: "default", effect: "plain" }, { default: s(() => [e[1] || (e[1] = d("span", null, "原产线：", -1)), d("span", null, w(z.value), 1)]), _: 1, __: [1] })]), titleRight: s(() => [l(n, { loading: y.value, type: "primary", size: "default", onClick: $ }, { default: s(() => e[2] || (e[2] = [P("确 认")])), _: 1, __: [2] }, 8, ["loading"])]), default: s(() => [l(h, { data: m.value, "return-source-data": "", "span-method": O, "cell-class-name": c(q), "max-height": c(E), style: { width: "100%" } }, { default: s(() => [l(t, { label: "序号", type: "index", align: "center", width: "60" }), l(t, { prop: "monomer.name", "show-overflow-tooltip": true, label: "单体", "min-width": "100", align: "center" }, { default: s(({ row: o }) => {
      var i;
      return [d("span", null, w((i = o.monomer) == null ? void 0 : i.name), 1)];
    }), _: 1 }), l(t, { prop: "area.name", "show-overflow-tooltip": true, label: "区域", "min-width": "100", align: "center" }, { default: s(({ row: o }) => {
      var i;
      return [d("span", null, w((i = o.area) == null ? void 0 : i.name), 1)];
    }), _: 1 }), l(t, { prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "100", align: "center" }, { default: s(({ row: o }) => [d("span", null, w(o.serialNumber), 1)]), _: 1 }), l(t, { prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120", align: "center" }), l(t, { prop: "length", "show-overflow-tooltip": true, label: "长度（mm）", "min-width": "90", align: "center" }), l(t, { prop: "editQuantity", "show-overflow-tooltip": true, label: "数量", "min-width": "90", align: "center" }, { default: s(({ row: o }) => [l(f, { modelValue: o.editQuantity, "onUpdate:modelValue": (i) => o.editQuantity = i, step: 1, min: 1, max: o.schedulingQuantity, precision: 0, size: "default", "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), l(t, { prop: "schedulingTotalNetWeight", "show-overflow-tooltip": true, label: "总重（kg）", "min-width": "90", align: "center" }), l(t, { prop: "curGroupsId", "show-overflow-tooltip": true, label: "选择生产组", "min-width": "150", align: "center" }, { default: s(({ row: o }) => [l(g, { modelValue: o.curGroupsId, "onUpdate:modelValue": (i) => o.curGroupsId = i, options: c(j), "popper-class": "group-cascader", props: { value: "id", label: "name", children: "children", expandTrigger: "hover", emitPath: false }, "show-all-levels": false, filterable: "", clearable: "", style: { width: "100%" }, placeholder: "请选择现生产组" }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["data", "cell-class-name", "max-height"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  ie as default
};
