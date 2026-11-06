import { ref as g } from "vue";
import { watch as A } from "vue";
import { resolveComponent as P } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as w } from "vue";
import { createElementVNode as _ } from "vue";
import { createVNode as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as u } from "vue";
import { withCtx as r } from "vue";
import { createCommentVNode as m } from "vue";
import { toDisplayString as h } from "vue";
import { createTextVNode as D } from "vue";
import { ElMessageBox as O } from "element-plus";
import { ElTableColumn as q } from "element-plus";
import { InfoFilled as M } from "@element-plus/icons-vue";
import { ElIcon as H } from "element-plus";
import { ElTooltip as j } from "element-plus";
import { ElSwitch as W } from "element-plus";
import { vLoading as $ } from "element-plus";
import { c as G, m as K, e as Q } from "./module/form.vue.js";
import { x as Y, o as Z, p9 as C, oV as z, oZ as E, es as J, G as I, aS as p, an as X, P as ee, pa as te } from "../../../../../shared/runtime.js";
import ae from "./module/header.vue.js";
import "../../../../../modules/index-9d220fe1.js";
import "../../../../../modules/use-users-4d979987.js";
import "../../../../../modules/process-select-b35dffc0.js";
import "../../../../../modules/raf-ac2cc4f2.js";
import "../../../../../modules/use-process-af1f8c99.js";
import "../../../../../modules/mes-bridge-enum-radio-5a510e87.js";
const se = { class: "app-container" }, oe = { class: "head-container" }, ne = { key: 0 }, ie = { key: 1 }, le = { style: { display: "inline-block" } }, we = { __name: "index", setup(re) {
  const d = te.base, T = g(), y = g([]), { crud: n, columns: k, CRUD: b } = Y({ title: "质检", sort: [], permission: { ...d }, optShow: { add: true }, crudApi: { ...G } }, T), { maxHeight: L } = Z({ paginate: true }), S = g([["inspectType", ["parse-enum", C]], ["firstInspectRate", ["suffix", "%"]]]);
  A(() => n.query.mesProductEnum, () => {
    N();
  });
  async function N() {
    try {
      const { content: i } = await z({ boolEnabledEnum: true, type: n.query.mesProductEnum });
      y.value = i || [];
    } catch (i) {
      console.log("获取车间信息失败", i);
    }
  }
  N();
  async function V(i, l) {
    try {
      await O.confirm('此操作将 "' + p.VL[l] + '" 该班组, 是否继续？', "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Q({ id: i.id, status: l, mesProductEnum: n.query.mesProductEnum }), n.refresh(), n.notify(p.VL[l] + "成功", b.NOTIFICATION_TYPE.SUCCESS);
    } catch (e) {
      console.log("变更状态", e), i.status = i.teamStatus === p.TRUE.V ? p.FALSE.V : p.TRUE.V;
    }
  }
  return b.HOOK.handleRefresh = (i, l) => {
    l.data.content = l.data.content.map((e) => {
      var f;
      return e.classificationId = e.classificationList.map((o) => o.classificationId), ((f = e.teamLink) == null ? void 0 : f.length) > 0 ? (e.teamIds = e.teamLink.map((o) => o.teamId), e.teamName = e.teamLink.map((o) => o.teamLeaderName), e.inspectUserIds = e.insepectUserList.map((o) => o.inspectUserId), e.inspectUserNames = e.insepectUserList.map((o) => o.inspectUserName)) : e.teamName = "暂无组员", e;
    });
  }, (i, l) => {
    const e = q, f = M, o = H, U = j, v = W, R = P("common-table"), F = $;
    return c(), w("div", se, [_("div", oe, [s(t(ae), { workshopList: y.value }, null, 8, ["workshopList"])]), B((c(), u(R, { ref_key: "tableRef", ref: T, data: t(n).data, "empty-text": t(n).emptyText, "max-height": t(L), style: { width: "100%" }, "data-format": S.value, "row-key": "id", onSelectionChange: t(n).selectionChangeHandler }, { default: r(() => [s(e, { label: "序号", type: "index", align: "center", width: "60" }), t(k).visible("workshopName") ? (c(), u(e, { key: "workshopName", prop: "workshopName", "show-overflow-tooltip": true, label: "车间", "min-width": "100px", align: "center" })) : m("", true), s(e, { key: "taskTypeEnum", align: "center", prop: "taskTypeEnum", label: "构件类型" }, { default: r(({ row: a }) => [a.taskTypeEnum !== t(E).ARTIFACT.V ? (c(), w("span", ne, h(t(E).VL[a.taskTypeEnum]), 1)) : m("", true), a.taskTypeEnum === t(E).ARTIFACT.V ? (c(), w("span", ie, h(t(J).VL[a.artifactType]), 1)) : m("", true)]), _: 1 }), s(e, { key: "processName", prop: "processName", "show-overflow-tooltip": true, align: "center", label: "工序" }), s(e, { key: "teamName", prop: "teamName", align: "center", label: "生产班组" }), s(e, { key: "inspectUserName", prop: "inspectUserName", "show-overflow-tooltip": true, label: "质检负责人", "min-width": "200px", align: "center" }, { default: r(({ row: a }) => [D(h(a.inspectUserNames ? a.inspectUserNames.join("、 ") : "-"), 1)]), _: 1 }), t(k).visible("inspectType") ? (c(), u(e, { key: "inspectType", prop: "inspectType", "show-overflow-tooltip": true, label: "质检方式", align: "center" })) : m("", true), s(e, { key: "firstInspectRate", prop: "firstInspectRate", align: "center", label: "抽检率" }, { default: r(({ row: a }) => [_("span", null, h(a.inspectType === t(C).ENUM.INSPECTION.L ? a.firstInspectRate : "-"), 1)]), _: 1 }), t(k).visible("teamStatus") ? (c(), u(e, { key: "teamStatus", prop: "teamStatus", label: "状态", align: "center", width: "80px" }, { header: r(() => [s(U, { class: "item", effect: "light", content: "禁用后不可质检", placement: "top" }, { default: r(() => [_("div", le, [l[0] || (l[0] = _("span", null, "状态", -1)), s(o, null, { default: r(() => [s(f)]), _: 1 })])]), _: 1 })]), default: r((a) => [s(v, { modelValue: a.row.status, "onUpdate:modelValue": (x) => a.row.status = x, disabled: !t(I)(t(d).editStatus), "active-color": "#409EFF", "inactive-color": "#F56C6C", "active-value": t(p).TRUE.V, "inactive-value": t(p).FALSE.V, onClick: (x) => V(a.row, a.row.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "active-value", "inactive-value", "onClick"])]), _: 1 })) : m("", true), t(I)([...t(d).edit, ...t(d).del]) ? (c(), u(e, { key: 3, label: "操作", width: "130px", align: "center", fixed: "right" }, { default: r((a) => [s(t(X), { data: a.row }, null, 8, ["data"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format", "onSelectionChange"])), [[F, t(n).loading]]), s(t(ee)), s(t(K), { workshopList: y.value }, null, 8, ["workshopList"])]);
  };
} };
export {
  we as default
};
