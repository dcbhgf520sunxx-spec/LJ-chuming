import { ref as n } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as M } from "vue";
import { createVNode as e } from "vue";
import { withCtx as i } from "vue";
import { withDirectives as F } from "vue";
import { createBlock as Q } from "vue";
import { unref as l } from "vue";
import { createTextVNode as J } from "vue";
import { isRef as A } from "vue";
import { Fragment as G } from "vue";
import { ElMessageBox as K } from "element-plus";
import { ElNotification as O } from "element-plus";
import { ElTableColumn as W } from "element-plus";
import { ElPagination as X } from "element-plus";
import { vLoading as Y } from "element-plus";
import { u as Z, J as ee, o as te, r2 as oe, r3 as ae } from "../../../../../shared/runtime.js";
import ne from "./module/edit-form.vue.js";
import le from "./module/header.vue.js";
import "../../../../../modules/use-scheduling-groups-e49a6ba2.js";
import "../../../../../modules/artifact-f1b0ca44.js";
const me = { __name: "index", props: { visible: { type: Boolean, default: false }, projectId: { type: [String, Number] } }, emits: ["update:visible", "refresh"], setup(w, { emit: C }) {
  const k = n(), h = C, R = w, { visible: s, handleClose: z } = Z({ emit: h, props: R, field: "visible", showHook: m, closeHook: S }), { handleSizeChange: N, handleCurrentChange: j, total: B, setTotalPage: H, queryPage: p } = ee({ fetchHook: m }), { maxHeight: T } = te({ mainBox: ".machine-part-un-product-record", extraBox: [".el-drawer__header"], wrapperBox: [".el-drawer__body"], navbar: false, clientHRepMainH: true, paginate: true, minHeight: 300 }, s), V = n([["createTime", ["parse-time", "{y}-{m}-{d}"]], ["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"]]), c = n(false), u = n(false), g = n([]), b = n({}), v = n({}), x = n(false);
  async function m() {
    try {
      u.value = true;
      const { content: o = [], totalElements: a } = await oe({ ...b.value, ...p });
      g.value = o, H(a);
    } catch (o) {
      console.error(o);
    } finally {
      u.value = false;
    }
  }
  function E(o) {
    b.value = { ...o }, d();
  }
  function d() {
    p.pageNumber = 1, m();
  }
  function S() {
    x.value && h("refresh");
  }
  function q(o) {
    v.value = o, c.value = true;
  }
  async function I(o) {
    try {
      await K.confirm(`是否对零件编号${o.serialNumber}进行撤回操作？
零件数量：${o.quantity}`, "提示", { type: "warning" }), await ae({ id: o.id, quantity: 0 }), O({ type: "success", title: "撤回成功", duration: 2e3 }), d(), x.value = true;
    } catch (a) {
      console.error(a);
    }
  }
  return (o, a) => {
    const t = W, _ = f("common-button"), P = f("common-table"), $ = X, U = f("common-drawer"), D = Y;
    return y(), M(G, null, [e(U, { ref_key: "drawerRef", ref: k, title: "零件剔除记录", modelValue: l(s), "onUpdate:modelValue": a[0] || (a[0] = (r) => A(s) ? s.value = r : null), direction: "rtl", "before-close": l(z), size: "100%", "custom-class": "machine-part-un-product-record" }, { titleRight: i(() => a[2] || (a[2] = [])), content: i(() => [e(le, { onToQuery: E, projectId: w.projectId }, null, 8, ["projectId"]), F((y(), Q(P, { data: g.value, "data-format": V.value, "max-height": l(T), style: { width: "100%" } }, { default: i(() => [e(t, { label: "序号", type: "index", align: "center", width: "60" }), e(t, { "show-overflow-tooltip": true, prop: "project", label: "所属项目", "min-width": "120px", align: "left" }), e(t, { "show-overflow-tooltip": true, prop: "monomer.name", label: "单体", "min-width": "100px", align: "left" }), e(t, { "show-overflow-tooltip": true, prop: "area.name", label: "区域", "min-width": "100px", align: "left" }), e(t, { "show-overflow-tooltip": true, prop: "artifactSerialNumber", label: "构件编号", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "workshop.name", label: "车间", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "productionLine.name", label: "生产线", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "groups.name", label: "班组", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "serialNumber", label: "零件编号", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "quantity", label: "零件数量", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "specification", label: "零件规格", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "material", label: "零件材质", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "askCompleteTime", label: "构件完成日期", width: "120px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "user.name", label: "操作人", "min-width": "100px", align: "center" }), e(t, { "show-overflow-tooltip": true, prop: "createTime", label: "操作时间", width: "120px", align: "center" }), e(t, { label: "操作", width: "150px", align: "center" }, { default: i(({ row: { sourceRow: r } }) => [e(_, { size: "default", type: "primary", icon: "el-icon-edit", onClick: (L) => q(r) }, null, 8, ["onClick"]), e(_, { size: "default", type: "success", icon: "el-icon-refresh-left", onClick: (L) => I(r) }, { default: i(() => a[3] || (a[3] = [J(" 撤回 ")])), _: 2, __: [3] }, 1032, ["onClick"])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[D, u.value]]), e($, { total: l(B), "current-page": l(p).pageNumber, "page-size": l(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: l(N), onCurrentChange: l(j) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]), e(ne, { visible: c.value, "onUpdate:visible": a[1] || (a[1] = (r) => c.value = r), info: v.value, onRefresh: d }, null, 8, ["visible", "info"])], 64);
  };
} };
export {
  me as default
};
