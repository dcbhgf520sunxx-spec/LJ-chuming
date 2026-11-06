import { ref as N } from "vue";
import { inject as j } from "vue";
import { watch as S } from "vue";
import { provide as L } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as d } from "vue";
import { createBlock as p } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as w } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as x } from "vue";
import { withDirectives as P } from "vue";
import { createVNode as l } from "vue";
import { vShow as T } from "vue";
import { createElementBlock as B } from "vue";
import { toDisplayString as b } from "vue";
import { ElMessageBox as U } from "element-plus";
import { ElNotification as G } from "element-plus";
import { ElTag as K } from "element-plus";
import { ElTableColumn as Q } from "element-plus";
import { ElCard as F } from "element-plus";
import { vLoading as J } from "element-plus";
import { l as f, x as W, o as X, G as k, i as Y } from "../../../../../shared/runtime.js";
import Z from "./module/form.vue.js";
import V from "./module/editFrom.vue.js";
import "../../../../../modules/use-table-operate-4f84437f.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
function ee(t) {
  return f({ url: "/api/rest/mes_process_conversion_rate/listAll", method: "get", params: t });
}
function te(t) {
  return f({ url: "/api/rest/mes_process_conversion_rate/add", method: "post", data: t });
}
function oe(t) {
  return f({ url: "/api/rest/mes_process_conversion_rate/update", method: "put", data: t });
}
function ae(t) {
  return f({ url: "/api/rest/mes_process_conversion_rate/delete", method: "delete", data: t });
}
function re() {
  return f({ module: "mes", url: "wage-quota-management/machine-part-quota-config/machine-part-process-select", method: "get" });
}
const A = { get: ee, batchAdd: te, edit: oe, del: ae }, ne = { class: "clearfix" }, se = { key: 0 }, ie = { key: 1 }, he = { __name: "index", props: { artifactCurrentRow: { type: Object, default: () => ({}) } }, setup(t) {
  const E = t, R = N(), v = N([]), _ = j("permission"), { crud: r, CRUD: D } = W({ title: "工序折合完工率", permission: { ..._ }, crudApi: { ...A }, hasPagination: false, queryOnPresenterCreated: false, dataPath: "" }, R), { maxHeight: q } = X({ extraBox: [".el-card__header"], paginate: false, extraHeight: 50 });
  S(() => E.artifactCurrentRow, (o) => {
    o != null && o.id ? (r.query.artifactClassId = o.id, r.toQuery()) : r.data = [];
  }, { immediate: true }), D.HOOK.handleRefresh = (o, a) => {
    var h;
    a.data = (h = a.data) == null ? void 0 : h.map((i) => {
      var c;
      return i.processType = +i.processType, (c = i.processIdArray) != null && c.length && (i.processIds = i.processIdArray.map((u) => (u = +u, u))), i;
    });
  };
  async function $() {
    try {
      const { content: o } = await re();
      v.value = o || [], console.log(o);
    } catch (o) {
      console.log(o);
    }
  }
  $();
  function z(o) {
    console.log(o, "rowrow"), U.confirm("是否确认删除改数据？", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning", draggable: true }).then(async () => {
      await A.del([o.id]), G({ title: "删除成功", type: "success", duration: 2500 }), r.refresh();
    }).catch((a) => {
      console.log(a, "删除失败");
    });
  }
  return L("machinePartProcess", v), (o, a) => {
    const h = g("common-tip-button"), i = K, c = Q, u = g("common-button"), H = g("common-table"), I = F, M = J;
    return d(), p(I, null, { header: s(() => {
      var m;
      return [w("div", ne, [a[2] || (a[2] = w("span", { class: "card-title" }, "工序折合完工率", -1)), e(k)(e(_).add) ? (d(), p(h, { key: 0, size: "default", type: "primary", style: { float: "right" }, disabled: !((m = t.artifactCurrentRow) != null && m.id), onClick: a[0] || (a[0] = (y) => e(r).toBatchAdd()) }, { default: s(() => a[1] || (a[1] = [C(" 新增 ")])), _: 1, __: [1] }, 8, ["disabled"])) : x("", true)])];
    }), default: s(() => {
      var m, y;
      return [P(l(i, { type: "info", size: "large" }, { default: s(() => a[3] || (a[3] = [C(" * 请先选择左侧构件类别 ")])), _: 1, __: [3] }, 512), [[T, !((m = t.artifactCurrentRow) != null && m.id)]]), P((d(), p(H, { ref_key: "tableRef", ref: R, data: e(r).data, "empty-text": e(r).emptyText, "max-height": e(q), style: { width: "100%" } }, { default: s(() => [l(c, { label: "序号", type: "index", align: "center", width: "60" }), l(c, { key: "conversionRate", prop: "conversionRate", "show-overflow-tooltip": "", label: "折合完工率" }, { default: s((n) => [e(Y)(n.row.conversionRate) ? (d(), B("span", se, b(n.row.conversionRate) + "%", 1)) : (d(), B("span", ie, "-"))]), _: 1 }), l(c, { key: "processNames", prop: "processNames", "show-overflow-tooltip": "", label: "工序" }, { default: s((n) => [w("span", null, b(n.row.processNames || ""), 1)]), _: 1 }), l(c, { key: "processTypeName", prop: "processTypeName", "show-overflow-tooltip": "", label: "工序类型" }, { default: s((n) => [C(b(n.row.processTypeName || "-"), 1)]), _: 1 }), l(c, { label: "操作", align: "center", fixed: "right" }, { default: s((n) => [e(k)(e(_).edit) ? (d(), p(u, { key: 0, type: "primary", size: "default", icon: "el-icon-edit", onClick: (O) => e(r).toEdit(n.row) }, null, 8, ["onClick"])) : x("", true), e(k)(e(_).del) ? (d(), p(u, { key: 1, type: "danger", size: "default", icon: "el-icon-delete", onClick: (O) => z(n.row) }, null, 8, ["onClick"])) : x("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[T, (y = t.artifactCurrentRow) == null ? void 0 : y.id], [M, e(r).loading]]), l(e(Z), { artifactCurrentRow: t.artifactCurrentRow }, null, 8, ["artifactCurrentRow"]), l(e(V), { artifactCurrentRow: t.artifactCurrentRow }, null, 8, ["artifactCurrentRow"])];
    }), _: 1 });
  };
} };
export {
  he as default
};
