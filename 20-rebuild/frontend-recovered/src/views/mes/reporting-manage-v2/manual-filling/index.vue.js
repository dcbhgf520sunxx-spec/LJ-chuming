import { ref as k } from "vue";
import { computed as V } from "vue";
import { watch as $ } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as g } from "vue";
import { createElementBlock as H } from "vue";
import { createElementVNode as s } from "vue";
import { createVNode as l } from "vue";
import { unref as _ } from "vue";
import { withDirectives as T } from "vue";
import { vShow as U } from "vue";
import { withCtx as n } from "vue";
import { createTextVNode as I } from "vue";
import { toDisplayString as p } from "vue";
import { createBlock as N } from "vue";
import { createCommentVNode as E } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElMessage as G } from "element-plus";
import { ElTag as O } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { ElInputNumber as J } from "element-plus";
import { b as W, f as X, u as Z } from "./unfinished-list/index.vue.js";
import { _ as ee, o as te, a3 as oe, o$ as ae, G as le, q5 as re, aw as ne } from "../../../../shared/runtime.js";
import "../../../../modules/process-config-df49251e.js";
import "../../../../modules/artifact-quota-config-f98bdf94.js";
import "./unfinished-list/module/header.vue.js";
import "../../../../modules/index-c07af747.js";
import "../../../../modules/process-select-b35dffc0.js";
import "../../../../modules/raf-ac2cc4f2.js";
import "../../../../modules/use-process-af1f8c99.js";
import "../../../../modules/use-production-team-d8043fd6.js";
const se = { class: "app-container" }, ie = { class: "wrap" }, ue = { class: "wrap-left" }, de = { class: "wrap-right" }, pe = { class: "right-header flex-rbc" }, ce = { __name: "index", setup(me) {
  const o = k([]), i = k(), y = k(false), { maxHeight: B } = te({ paginate: false });
  function M(a) {
    o.value = o.value.filter((t) => t.rowKey !== a.rowKey).map((t) => ({ ...t, reportQuantity: t.unreportedQuantity })), o.value.length > 0 && o.value[0].reportPersonId === -1 && (o.value[0].reportPersonId = void 0);
  }
  const R = { reportQuantity: [{ required: true, message: "请输入数量", trigger: "change" }], reportPersonId: [{ required: true, message: "请选择班组", trigger: "change" }] }, A = /* @__PURE__ */ new Map([["reportPersonId", -1]]), { tableValidate: S, cleanUpData: j, wrongCellMask: z } = ne({ rules: R, ditto: A }), D = V(() => o.value.reduce((a, t) => a + Number(t.reportQuantity || 0), 0)), P = V(() => {
    var a, t;
    return ((t = (a = i.value) == null ? void 0 : a.form) == null ? void 0 : t.productType) === oe.ENCLOSURE.V;
  }), q = V(() => {
    var a;
    return ((a = i.value) == null ? void 0 : a.form.boolFixedProcess) === ae.YES.V ? W : X;
  });
  async function F() {
    var a, t, c, m, r, v;
    try {
      const { validResult: d, dealList: b } = S(o.value);
      if (d) o.value = b;
      else return d;
      await K.confirm("是否确认保存？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), y.value = true, j(o.value);
      const x = { processId: ((t = (a = i.value) == null ? void 0 : a.form) == null ? void 0 : t.processId) || void 0, teamId: ((m = (c = i.value) == null ? void 0 : c.form) == null ? void 0 : m.teamId) || void 0, productTypeEnum: ((v = (r = i.value) == null ? void 0 : r.form) == null ? void 0 : v.productType) || void 0 };
      o.value = o.value.map((f) => ({ ...f, boolAssistEnum: f.boolAssist })), await q.value(x, o.value || []), G.success("保存成功！"), i.value.refresh();
    } catch (d) {
      console.log(d);
    } finally {
      y.value = false;
    }
  }
  return $(() => {
    var a;
    return (a = i.value) == null ? void 0 : a.form;
  }, () => {
    o.value = [];
  }, { immediate: true, deep: true }), (a, t) => {
    var f, Q;
    const c = O, m = h("common-button"), r = Y, v = h("table-cell-tag"), d = J, b = h("common-select"), x = h("common-table");
    return g(), H("div", se, [s("div", ie, [s("div", ue, [l(_(Z), { ref_key: "unfinishedListRef", ref: i, addList: o.value, "onUpdate:addList": t[0] || (t[0] = (w) => o.value = w) }, null, 8, ["addList"])]), s("div", de, [T(s("div", null, [l(c, { type: "info", size: "large" }, { default: n(() => t[1] || (t[1] = [I(" *点击左侧添加按钮将数据添加到此列表")])), _: 1, __: [1] })], 512), [[U, !((f = o.value) != null && f.length)]]), T(s("div", null, [s("div", pe, [l(c, { size: "large" }, { default: n(() => [I("数量：" + p(D.value || "-"), 1)]), _: 1 }), s("div", null, [_(le)(_(re).save) ? (g(), N(m, { key: 0, loading: y.value, size: "default", type: "success", onClick: F }, { default: n(() => t[2] || (t[2] = [I(" 保存 ")])), _: 1, __: [2] }, 8, ["loading"])) : E("", true)])]), l(x, { data: o.value, "max-height": _(B), "return-source-data": "", showEmptySymbol: false, "cell-class-name": _(z), style: { width: "100%" } }, { default: n(() => {
      var w, L;
      return [l(r, { prop: "index", label: "序号", align: "center", width: "50", type: "index", fixed: "left" }), l(r, { label: "项目", prop: "project", key: "project", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: n((e) => {
        var u, C;
        return [s("span", null, p((u = e.row.project) == null ? void 0 : u.serialNumber) + " - " + p((C = e.row.project) == null ? void 0 : C.shortName), 1)];
      }), _: 1 }), l(r, { label: "单体/区域", prop: "monomer", key: "monomer", "show-overflow-tooltip": "", align: "center", "min-width": "120" }, { default: n((e) => [s("span", null, p(e.row.monomerName) + " / " + p(e.row.areaName), 1)]), _: 1 }), l(r, { label: "编号", prop: "serialNumber", key: "serialNumber", "show-overflow-tooltip": "", align: "center" }, { default: n((e) => [e.row.serialNumber ? (g(), N(v, { key: 0, name: P.value ? "围护" : "结构", color: P.value ? "#ff7300" : "#0066ff", offset: 0 }, null, 8, ["name", "color"])) : E("", true), s("span", null, p(e.row.serialNumber || "-"), 1)]), _: 1 }), l(r, { label: "规格/类型", prop: "specification", key: "specification", "show-overflow-tooltip": "", align: "center" }, { default: n((e) => [s("span", null, p(e.row.specification || "-"), 1)]), _: 1 }), l(r, { label: "数量", prop: "reportQuantity", key: "reportQuantity", "show-overflow-tooltip": "", align: "center" }, { default: n((e) => [l(d, { modelValue: e.row.reportQuantity, "onUpdate:modelValue": (u) => e.row.reportQuantity = u, placeholder: "输入", min: 1, max: e.row.unreportedQuantity, step: 1, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "max"])]), _: 1 }), ((L = (w = i.value) == null ? void 0 : w.form) == null ? void 0 : L.processId) === 38 ? (g(), N(r, { label: "打孔数", prop: "perforateQuantity", key: "perforateQuantity", "show-overflow-tooltip": "", align: "center" }, { default: n((e) => [l(d, { modelValue: e.row.perforateQuantity, "onUpdate:modelValue": (u) => e.row.perforateQuantity = u, placeholder: "输入", min: 1, step: 1, "controls-position": "right", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 })) : E("", true), l(r, { label: "上报人", prop: "reportPersonId", key: "reportPersonId", "show-overflow-tooltip": "", align: "center" }, { default: n((e) => [l(b, { modelValue: e.row.reportPersonId, "onUpdate:modelValue": (u) => e.row.reportPersonId = u, options: i.value.crewList, "data-structure": { key: "userId", label: "userName", value: "userId" }, size: "default", clearable: "", "show-extra": e.$index !== 0, placeholder: "上报人", style: { width: "100%" } }, null, 8, ["modelValue", "onUpdate:modelValue", "options", "show-extra"])]), _: 1 }), l(r, { label: "操作", align: "center", width: "100" }, { default: n((e) => [l(m, { icon: "el-icon-delete", size: "default", type: "danger", onClick: (u) => M(e.row) }, null, 8, ["onClick"])]), _: 1 })];
    }), _: 1 }, 8, ["data", "max-height", "cell-class-name"])], 512), [[U, ((Q = o.value) == null ? void 0 : Q.length) > 0]])])])]);
  };
} }, Ie = ee(ce, [["__scopeId", "data-v-3919feb9"]]);
export {
  Ie as default
};
