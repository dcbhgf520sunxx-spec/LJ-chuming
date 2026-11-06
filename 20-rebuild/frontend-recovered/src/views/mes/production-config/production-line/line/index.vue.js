import { useStore as j } from "vuex";
import { ref as E } from "vue";
import { inject as M } from "vue";
import { watch as W } from "vue";
import { resolveComponent as C } from "vue";
import { resolveDirective as z } from "vue";
import { openBlock as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as s } from "vue";
import { toDisplayString as _ } from "vue";
import { unref as e } from "vue";
import { withDirectives as R } from "vue";
import { createTextVNode as x } from "vue";
import { createVNode as r } from "vue";
import { createCommentVNode as f } from "vue";
import { ElMessageBox as G } from "element-plus";
import { ElTableColumn as Y } from "element-plus";
import { InfoFilled as J } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElTooltip as X } from "element-plus";
import { ElSwitch as Z } from "element-plus";
import { ElCard as ee } from "element-plus";
import { vLoading as oe } from "element-plus";
import { c as te, e as ae } from "../../../../../modules/production-line-c52339bd.js";
import { _ as ne, x as le, p5 as b, oV as se, aR as ie, a3 as N, G as O, aS as p, an as re, P as de } from "../../../../../shared/runtime.js";
import ce from "./module/header.vue.js";
import ue from "./module/form.vue.js";
import "../../../../../modules/factory-select-b8d0a4ac.js";
import "../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const me = { style: { "line-height": "28px" } }, pe = { class: "head-container" }, _e = { style: { "margin-right": "20px" } }, fe = { style: { display: "inline-block" } }, be = { __name: "index", setup(he) {
  const T = j(), D = { add: false, edit: false, del: false, download: false }, V = E(), { crud: l, columns: h, CRUD: y } = le({ title: "生产线", sort: [], permission: { ...b }, optShow: { ...D }, crudApi: { ...te }, invisibleColumns: ["shortName", "factoryName"] }, V), k = E([]), A = E([["targetProductionShow", ["to-fixed", 2]]]), S = E([]), F = M("maxHeight");
  W(() => l.query.mesProductEnum, () => {
    v();
  });
  async function v() {
    try {
      const { content: i } = await se({ boolEnabledEnum: true, type: l.query.mesProductEnum });
      S.value = i || [], console.log(":crud", l);
    } catch (i) {
      console.log("获取车间信息失败", i);
    }
  }
  v();
  async function U(i, t) {
    try {
      await G.confirm('此操作将 "' + p.VL[t] + '" ' + i.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await ae({ id: i.id, boolEnabledEnum: t }), l.refresh(), l.notify(p.VL[t] + "成功", y.NOTIFICATION_TYPE.SUCCESS), L();
    } catch (a) {
      console.log("变更生产线状态", a), i.boolEnabledEnum = i.boolEnabledEnum === p.TRUE.V ? p.FALSE.V : p.TRUE.V;
    }
  }
  y.HOOK.handleRefresh = (i, { data: t }) => {
    t.content.forEach((a) => {
      var d, g, w;
      a.targetProductionShow = a.targetProduction && a.targetProduction / 1e3 || 0, a.typeSequence = (g = (d = a == null ? void 0 : a.typeList) == null ? void 0 : d.map((m) => `【${m == null ? void 0 : m.name}】`)) == null ? void 0 : g.join(""), a.linkIdList = ((w = a == null ? void 0 : a.typeList) == null ? void 0 : w.map((m) => m.id)) || [];
    });
  }, y.HOOK.afterSubmit = () => {
    L();
  }, y.HOOK.afterDelete = () => {
    L();
  };
  function L() {
    T.commit("config/SET_LOADED", { key: "productLines", loaded: false }), T.commit("config/SET_LOADED", { key: "onlyProductLines", loaded: false });
  }
  return (i, t) => {
    const a = C("common-button"), d = Y, g = C("table-cell-tag"), w = J, m = Q, I = X, B = Z, H = C("common-table"), K = ee, q = z("permission"), $ = oe;
    return c(), u(K, { class: "line-box box-card" }, { header: n(() => [s("span", me, _(e(l).title) + "列表", 1), R((c(), u(a, { style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", onClick: e(l).toAdd }, { default: n(() => t[1] || (t[1] = [x(" 新增 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[q, e(b).add]])]), default: n(() => [s("div", pe, [r(e(ce), { workshopList: S.value }, null, 8, ["workshopList"])]), R((c(), u(H, { ref_key: "tableRef", ref: V, "highlight-current-row": "", data: e(l).data, "empty-text": e(l).emptyText, "data-format": A.value, "max-height": e(F), "default-expand-all": false, "expand-row-keys": k.value, "row-key": "id", style: { width: "100%" } }, { default: n(() => [r(ie, { data: e(l).data, "expand-row-keys": k.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (o) => k.value = o), "row-key": "id", fixed: "left" }, { default: n(({ row: { sourceRow: o } }) => [s("p", null, [t[2] || (t[2] = x(" 工厂：")), s("span", _e, _(o.factoryName), 1), t[3] || (t[3] = x(" 车间：")), s("span", null, _(o.workshopName), 1)]), s("p", null, [t[4] || (t[4] = x(" 备注：")), s("span", null, _(o.remark), 1)])]), _: 1 }, 8, ["data", "expand-row-keys"]), r(d, { label: "序号", type: "index", align: "center", width: "60" }), e(h).visible("workshopName") ? (c(), u(d, { key: "workshopName", prop: "workshopName", label: "车间名称", align: "center" })) : f("", true), e(h).visible("name") ? (c(), u(d, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "生产线名称", width: "600" }, { default: n(({ row: o }) => [o.productType ? (c(), u(g, { key: 0, name: e(N).V[o.productType].SL, color: e(N).V[o.productType].COLOR, offset: 25 }, null, 8, ["name", "color"])) : f("", true), s("span", null, _(o.name), 1)]), _: 1 })) : f("", true), e(h).visible("targetProductionShow") ? (c(), u(d, { key: "targetProductionShow", prop: "targetProductionShow", "show-overflow-tooltip": true, label: "目标产量(吨/月)", align: "center" }, { default: n(({ row: o }) => [s("span", null, _(o.targetProductionShow), 1)]), _: 1 })) : f("", true), e(h).visible("boolEnabledEnum") ? (c(), u(d, { key: "boolEnabledEnum", prop: "boolEnabledEnum", label: "状态", align: "center" }, { header: n(() => [r(I, { class: "item", effect: "light", content: "生产线被禁用后，该生产线无法再在其它页面中显示", placement: "top" }, { default: n(() => [s("div", fe, [t[5] || (t[5] = s("span", null, "状态", -1)), r(m, null, { default: n(() => [r(w)]), _: 1 })])]), _: 1 })]), default: n((o) => [r(B, { modelValue: o.row.boolEnabledEnum, "onUpdate:modelValue": (P) => o.row.boolEnabledEnum = P, disabled: !e(O)(e(b).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": e(p).TRUE.V, "inactive-value": e(p).FALSE.V, onChange: (P) => U(o.row, o.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onChange"])]), _: 1 })) : f("", true), e(O)([...e(b).del, ...e(b).edit]) ? (c(), u(d, { key: 4, label: "操作", align: "center", fixed: "right" }, { default: n((o) => [r(e(re), { data: o.row }, null, 8, ["data"])]), _: 1 })) : f("", true)]), _: 1 }, 8, ["data", "empty-text", "data-format", "max-height", "expand-row-keys"])), [[$, e(l).loading]]), r(e(de)), r(e(ue), { workshopList: S.value }, null, 8, ["workshopList"])]), _: 1 });
  };
} }, Le = ne(be, [["__scopeId", "data-v-0c12657b"]]);
export {
  Le as default
};
