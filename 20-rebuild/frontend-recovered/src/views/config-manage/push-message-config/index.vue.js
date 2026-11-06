import { ref as v } from "vue";
import { resolveComponent as B } from "vue";
import { openBlock as t } from "vue";
import { createElementBlock as a } from "vue";
import { createElementVNode as p } from "vue";
import { createVNode as T } from "vue";
import { withCtx as m } from "vue";
import { unref as o } from "vue";
import { withDirectives as H } from "vue";
import { createBlock as h } from "vue";
import { createCommentVNode as _ } from "vue";
import { Fragment as D } from "vue";
import { renderList as C } from "vue";
import { normalizeClass as N } from "vue";
import { toDisplayString as b } from "vue";
import { withModifiers as F } from "vue";
import { createTextVNode as Q } from "vue";
import { ElMessageBox as q } from "element-plus";
import { ElTableColumn as z } from "element-plus";
import { ElSwitch as K } from "element-plus";
import { vLoading as W } from "element-plus";
import { c as X, e as Y } from "../../../modules/push-message-49ab2649.js";
import { _ as J, x as Z, fN as x, o as tt, fO as w, dX as E, fP as et, fQ as it, G as ot } from "../../../shared/runtime.js";
import at from "./module/header.vue.js";
import nt from "./module/push-setting.vue.js";
import "../../../modules/use-table-operate-4f84437f.js";
const st = { class: "app-container" }, lt = { class: "head-container" }, ct = { key: 1, class: "sandwich-cell-bottom" }, ut = { key: 1, class: "sandwich-cell-bottom" }, rt = { key: 0 }, pt = { style: { "margin-left": "6px" } }, dt = { key: 1 }, ft = { style: { "margin-left": "6px" } }, mt = { key: 2 }, ht = { key: 1, class: "sandwich-cell-bottom" }, _t = { key: 1, class: "sandwich-cell-bottom" }, yt = { key: 1, class: "sandwich-cell-bottom" }, gt = { __name: "index", setup(bt) {
  const A = { add: false, edit: false, del: false, download: false }, U = v([]), j = v([]), V = v(), k = v(false), S = v({}), { crud: g, CRUD: M, columns: y } = Z({ title: "消息推送配置", sort: [], dataPath: "", permission: { ...x }, optShow: { ...A }, crudApi: { ...X }, hasPagination: false }, V), { maxHeight: $ } = tt({ paginate: false });
  M.HOOK.handleRefresh = (c, s) => {
    var l;
    s.data.content = s.data, (l = s.data.content) == null || l.forEach((u) => {
      var L, O;
      !u.pushNotificationConfigDetailDTOList || !((L = u.pushNotificationConfigDetailDTOList) != null && L.length) ? u._colspan = 5 : u._colspan = 0, (O = u.pushNotificationConfigDetailDTOList) == null || O.forEach((d) => {
        var e, n;
        d.members = (n = (e = d.suitableObjectCommonDTOList) == null ? void 0 : e.map((i) => i.name)) == null ? void 0 : n.join("、"), d.originStatus = d.status, d.notificationModeTypeEnum !== w.REGULAR.V && d.notificationModeTypeEnum !== w.RATION.V ? d._wayColspan = 2 : d._wayColspan = 0;
      });
    });
  };
  async function P(c, s, l) {
    try {
      await q.confirm(`此操作将把“${c.notificationTypeName}”的数据状态更改为“${E.VL[l]}”, 是否继续？`, "提示", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }), await Y(s.id), g.notify(`“${c.notificationTypeName}”的数据状态变更为“${E.VL[l]}”成功`, M.NOTIFICATION_TYPE.SUCCESS), g.refresh();
    } catch (u) {
      console.log(u), s.status = s.originStatus;
    }
  }
  function I(c) {
    c.notificationLevelConfig = String.fromCharCode(c.notificationLevelConfig), console.log(c, "row"), S.value = c, k.value = true;
  }
  function G({ row: c, rowIndex: s, column: l, columnIndex: u }) {
    if (u === 3) return c._colspan > 0 ? [1, c._colspan] : [1, 1];
    if (u > 3 && u < 8 && c._colspan > 0) return [0, 0];
    if (u === 4) return c._wayColspan > 0 ? [1, 2] : [1, 1];
    if (u === 5 && c._wayColspan > 0) return [0, 0];
  }
  return (c, s) => {
    const l = z, u = K, L = B("common-button"), O = B("common-table"), d = W;
    return t(), a("div", st, [p("div", lt, [T(o(at), { "detail-list": j.value }, { colorSetting: m(() => s[1] || (s[1] = [])), _: 1 }, 8, ["detail-list"])]), H((t(), h(O, { ref_key: "tableRef", ref: V, data: o(g).data, "empty-text": o(g).emptyText, "max-height": o($), class: "upload-table", "span-method": G, style: { width: "100%" } }, { default: m(() => [T(l, { label: "序号", type: "index", align: "center", width: "60" }), o(y).visible("operationalModuleTypeName") ? (t(), h(l, { key: "operationalModuleTypeName", prop: "operationalModuleTypeName", "show-overflow-tooltip": true, label: "业务模块", align: "center" })) : _("", true), o(y).visible("notificationTypeName") ? (t(), h(l, { key: "notificationTypeName", prop: "notificationTypeName", "show-overflow-tooltip": true, label: "通知业务", align: "center" })) : _("", true), o(y).visible("status") ? (t(), h(l, { key: "status", prop: "status", "show-overflow-tooltip": true, label: "启用状态", align: "center" }, { default: m(({ row: e }) => {
      var n;
      return [((n = e.pushNotificationConfigDetailDTOList) == null ? void 0 : n.length) > 0 ? (t(true), a(D, { key: 0 }, C(e.pushNotificationConfigDetailDTOList, (i, f) => {
        var r;
        return t(), a("div", { key: i.id }, [p("div", { class: N(f === ((r = e.pushNotificationConfigDetailDTOList) == null ? void 0 : r.length) - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [T(u, { modelValue: i.status, "onUpdate:modelValue": (R) => i.status = R, "active-value": o(E).ENABLED.V, "inactive-value": o(E).UN_ENABLE.V, class: "drawer-switch", onChange: (R) => P(e, i, i.status) }, null, 8, ["modelValue", "onUpdate:modelValue", "active-value", "inactive-value", "onChange"])], 2)]);
      }), 128)) : (t(), a("div", ct, "-"))];
    }), _: 1 })) : _("", true), o(y).visible("notificationModeTypeEnum") ? (t(), h(l, { key: "notificationModeTypeEnum", prop: "notificationModeTypeEnum", "show-overflow-tooltip": true, label: "通知方式", align: "center" }, { default: m(({ row: e }) => {
      var n;
      return [((n = e.pushNotificationConfigDetailDTOList) == null ? void 0 : n.length) > 0 ? (t(true), a(D, { key: 0 }, C(e.pushNotificationConfigDetailDTOList, (i, f) => {
        var r;
        return t(), a("div", { key: i.id }, [p("div", { class: N(f === ((r = e.pushNotificationConfigDetailDTOList) == null ? void 0 : r.length) - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [p("span", null, b(o(w).VL[i.notificationModeTypeEnum]), 1)], 2)]);
      }), 128)) : (t(), a("div", ut, "-"))];
    }), _: 1 })) : _("", true), o(y).visible("duration") ? (t(), h(l, { key: "duration", prop: "duration", "show-overflow-tooltip": true, label: "定时通知配置", align: "center" }, { default: m(({ row: e }) => {
      var n;
      return [((n = e.pushNotificationConfigDetailDTOList) == null ? void 0 : n.length) > 0 ? (t(true), a(D, { key: 0 }, C(e.pushNotificationConfigDetailDTOList, (i, f) => {
        var r;
        return t(), a("div", { key: i.id }, [p("div", { class: N(f === ((r = e.pushNotificationConfigDetailDTOList) == null ? void 0 : r.length) - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [i.notificationModeTypeEnum === o(w).REGULAR.V ? (t(), a("div", rt, [p("span", null, b(i.duration ? i.duration : "-"), 1), p("span", pt, b(o(et).VL[i.timeTypeEnum]), 1)])) : i.notificationModeTypeEnum === o(w).RATION.V ? (t(), a("div", dt, [s[2] || (s[2] = p("span", null, "数量：", -1)), p("span", ft, b(i.number ? i.number : "-"), 1)])) : (t(), a("div", mt, "-"))], 2)]);
      }), 128)) : (t(), a("div", ht, "-"))];
    }), _: 1 })) : _("", true), o(y).visible("suitableObjectTypeEnum") ? (t(), h(l, { key: "suitableObjectTypeEnum", prop: "suitableObjectTypeEnum", "show-overflow-tooltip": true, label: "适用范围", align: "center" }, { default: m(({ row: e }) => {
      var n;
      return [((n = e.pushNotificationConfigDetailDTOList) == null ? void 0 : n.length) > 0 ? (t(true), a(D, { key: 0 }, C(e.pushNotificationConfigDetailDTOList, (i, f) => {
        var r;
        return t(), a("div", { key: i.id }, [p("div", { class: N(f === ((r = e.pushNotificationConfigDetailDTOList) == null ? void 0 : r.length) - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [p("span", null, b(o(it).VL[i.suitableObjectTypeEnum]), 1)], 2)]);
      }), 128)) : (t(), a("div", _t, "-"))];
    }), _: 1 })) : _("", true), o(y).visible("members") ? (t(), h(l, { key: "members", prop: "members", "show-overflow-tooltip": true, label: "部门/岗位/人员", align: "center", "min-width": "180" }, { default: m(({ row: e }) => {
      var n;
      return [((n = e.pushNotificationConfigDetailDTOList) == null ? void 0 : n.length) > 0 ? (t(true), a(D, { key: 0 }, C(e.pushNotificationConfigDetailDTOList, (i, f) => {
        var r;
        return t(), a("div", { key: i.id }, [p("div", { class: N(f === ((r = e.pushNotificationConfigDetailDTOList) == null ? void 0 : r.length) - 1 ? "sandwich-cell-bottom" : "sandwich-cell-top") }, [p("span", null, b(i.members), 1)], 2)]);
      }), 128)) : (t(), a("div", yt, "-"))];
    }), _: 1 })) : _("", true), T(l, { label: "操作", width: "150px", align: "center" }, { default: m(({ row: e }) => [o(ot)(o(x).setting) ? (t(), h(L, { key: 0, class: "filter-item", type: "primary", onClick: F((n) => I(e), ["stop"]) }, { default: m(() => s[3] || (s[3] = [Q(" 设置 ")])), _: 2, __: [3] }, 1032, ["onClick"])) : _("", true)]), _: 1 })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[d, o(g).loading]]), T(o(nt), { visible: k.value, "onUpdate:visible": s[0] || (s[0] = (e) => k.value = e), "notice-data": S.value, "detail-list": U.value, permission: o(x), onSuccess: o(g).toQuery }, null, 8, ["visible", "notice-data", "detail-list", "permission", "onSuccess"])]);
  };
} }, Lt = J(gt, [["__scopeId", "data-v-ad2cb826"]]);
export {
  Lt as default
};
