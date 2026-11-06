import { useStore as z } from "vuex";
import { ref as b } from "vue";
import { inject as Q } from "vue";
import { onMounted as Y } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as J } from "vue";
import { openBlock as c } from "vue";
import { createBlock as u } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as a } from "vue";
import { toDisplayString as p } from "vue";
import { unref as e } from "vue";
import { withDirectives as T } from "vue";
import { createTextVNode as f } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as g } from "vue";
import { ElMessageBox as W } from "element-plus";
import { ElTableColumn as X } from "element-plus";
import { InfoFilled as Z } from "@element-plus/icons-vue";
import { ElIcon as ee } from "element-plus";
import { ElTooltip as te } from "element-plus";
import { ElSwitch as oe } from "element-plus";
import { ElCard as ne } from "element-plus";
import { vLoading as ae } from "element-plus";
import { _ as le, x as ie, dO as _, dP as se, aR as de, a3 as L, aS as m, G as V, an as re, P as ce, dQ as ue, dR as me } from "../../../../../../shared/runtime.js";
import pe from "./module/header.vue.js";
import fe from "./module/form.vue.js";
import "../../../../../../modules/factory-select-b8d0a4ac.js";
const _e = { style: { "line-height": "28px" } }, ye = { class: "head-container" }, be = { style: { "margin-right": "20px" } }, ge = { style: { display: "inline-block" } }, Ee = { __name: "index", emits: ["click-line"], setup(he, { emit: R }) {
  const C = z(), O = R, D = { add: false, edit: false, del: false, download: false }, k = b(), { crud: d, columns: v, CRUD: y } = ie({ title: "生产线", sort: [], permission: { ..._ }, optShow: { ...D }, crudApi: { ...se }, invisibleColumns: ["shortName", "factoryName", "workshopName"] }, k), E = b([]), N = b([["targetProductionShow", ["to-fixed", 2]]]), P = Q("maxHeight"), h = b([]);
  async function A() {
    try {
      const { content: n } = await ue();
      h.value = n || [];
    } catch (n) {
      console.log(n);
    }
  }
  Y(() => {
    A();
  });
  async function F(n, t) {
    try {
      await W.confirm('此操作将 "' + m.VL[t] + '" ' + n.name + ", 是否继续？", "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await me({ id: n.id, boolEnabledEnum: t }), d.refresh(), d.notify(m.VL[t] + "成功", y.NOTIFICATION_TYPE.SUCCESS), x();
    } catch (s) {
      console.log("变更生产线状态", s), n.boolEnabledEnum = n.boolEnabledEnum === m.TRUE.V ? m.FALSE.V : m.TRUE.V;
    }
  }
  function I(n) {
    n && O("click-line", n);
  }
  y.HOOK.handleRefresh = (n, { data: t }) => {
    t.content.forEach((s) => {
      s != null && s.linkIdList && (s.typeSequence = h.value.filter((r) => s.linkIdList.includes(r.id)).map((r) => `【 ${r.label} 】`).join(" "));
    });
  }, y.HOOK.afterSubmit = () => {
    x();
  }, y.HOOK.afterDelete = () => {
    x();
  };
  function x() {
    C.commit("config/SET_LOADED", { key: "productLines", loaded: false }), C.commit("config/SET_LOADED", { key: "onlyProductLines", loaded: false });
  }
  return (n, t) => {
    const s = w("common-button"), r = X, U = w("table-cell-tag"), B = Z, H = ee, K = te, M = oe, $ = w("common-table"), j = ne, q = J("permission"), G = ae;
    return c(), u(j, { class: "line-box box-card" }, { header: l(() => [a("span", _e, p(e(d).title) + "列表", 1), T((c(), u(s, { icon: "el-icon-plus", size: "default", style: { float: "right", padding: "6px 10px" }, type: "primary", onClick: e(d).toAdd }, { default: l(() => t[1] || (t[1] = [f(" 新增 ")])), _: 1, __: [1] }, 8, ["onClick"])), [[q, e(_).add]])]), default: l(() => [a("div", ye, [i(e(pe))]), T((c(), u($, { ref_key: "tableRef", ref: k, data: e(d).data, "data-format": N.value, "default-expand-all": false, "empty-text": e(d).emptyText, "expand-row-keys": E.value, "max-height": e(P), "highlight-current-row": "", "row-key": "id", style: { width: "100%" }, onCurrentChange: I }, { default: l(() => [i(de, { "expand-row-keys": E.value, "onUpdate:expandRowKeys": t[0] || (t[0] = (o) => E.value = o), data: e(d).data, fixed: "left", "row-key": "id" }, { default: l(({ row: { sourceRow: o } }) => [a("p", null, [t[2] || (t[2] = f(" 工厂：")), a("span", be, p(o.factoryName), 1), t[3] || (t[3] = f(" 车间：")), a("span", null, p(o.workshopName), 1)]), a("p", null, [t[4] || (t[4] = f(" 可生产产品种类：")), a("span", null, p(o.typeSequence), 1)]), a("p", null, [t[5] || (t[5] = f(" 备注：")), a("span", null, p(o.remark), 1)])]), _: 1 }, 8, ["expand-row-keys", "data"]), i(r, { align: "center", label: "序号", type: "index", width: "60" }), e(v).visible("name") ? (c(), u(r, { key: "name", "show-overflow-tooltip": true, label: "生产线名称", "min-width": "140px", prop: "name" }, { default: l(({ row: o }) => [o.productType ? (c(), u(U, { key: 0, color: e(L).V[o.productType].COLOR, name: e(L).V[o.productType].SL, offset: 15 }, null, 8, ["color", "name"])) : g("", true), a("span", null, p(o.name), 1)]), _: 1 })) : g("", true), e(v).visible("boolEnabledEnum") ? (c(), u(r, { key: "boolEnabledEnum", align: "center", label: "状态", prop: "boolEnabledEnum", width: "80px" }, { header: l(() => [i(K, { content: "生产线被禁用后，该生产线无法再在其它页面中显示", class: "item", effect: "light", placement: "top" }, { default: l(() => [a("div", ge, [t[6] || (t[6] = a("span", null, "状态", -1)), i(H, null, { default: l(() => [i(B)]), _: 1 })])]), _: 1 })]), default: l((o) => [i(M, { modelValue: o.row.boolEnabledEnum, "onUpdate:modelValue": (S) => o.row.boolEnabledEnum = S, "active-value": e(m).TRUE.V, disabled: !e(V)(e(_).editStatus), "inactive-value": e(m).FALSE.V, "active-color": "#409EFF", "inactive-color": "#F56C6C", onChange: (S) => F(o.row, o.row.boolEnabledEnum) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "disabled", "inactive-value", "onChange"])]), _: 1 })) : g("", true), e(V)([...e(_).del, ...e(_).edit]) ? (c(), u(r, { key: 2, align: "center", fixed: "right", label: "操作", width: "130px" }, { default: l((o) => [i(e(re), { data: o.row }, null, 8, ["data"])]), _: 1 })) : g("", true)]), _: 1 }, 8, ["data", "data-format", "empty-text", "expand-row-keys", "max-height"])), [[G, e(d).loading]]), i(e(ce)), i(e(fe), { "product-type-list": h.value }, null, 8, ["product-type-list"])]), _: 1 });
  };
} }, Se = le(Ee, [["__scopeId", "data-v-d49c954e"]]);
export {
  Se as default
};
