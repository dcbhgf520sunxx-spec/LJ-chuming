import { ref as y } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as c } from "vue";
import { createBlock as f } from "vue";
import { withCtx as a } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as C } from "vue";
import { unref as r } from "vue";
import { createElementVNode as u } from "vue";
import { createCommentVNode as k } from "vue";
import { toDisplayString as _ } from "vue";
import { isRef as D } from "vue";
import { ElNotification as H } from "element-plus";
import { ElTableColumn as E } from "element-plus";
import { s as L } from "../../../../../../modules/common-8949b382.js";
import { _ as P, u as R, o as j } from "../../../../../../shared/runtime.js";
const z = { __name: "preview-dialog", props: { visible: { type: Boolean, default: false }, list: { type: Array, default: () => [] }, info: { type: Object, default: () => {
} } }, emits: ["update:visible", "success"], setup(s, { emit: x }) {
  const g = x, b = s, { visible: i, handleClose: m } = R({ emit: g, props: b, field: "visible" }), { maxHeight: N } = j({ mainBox: ".nesting-task-issue-preview", extraBox: [".el-dialog__header", ".tip"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, i), V = y([["askCompleteTime", ["parse-time", "{y}-{m}-{d}"]]]), d = y(false);
  async function B() {
    try {
      d.value = true;
      const n = b.list.map((e) => ({ askCompleteTime: e.askCompleteTime, groupsId: e.groupsId, id: e.id, nestCutPlateId: e.nestCutPlateId }));
      await L({ machinePartDetailList: n }), m(), H({ title: "任务下发成功", type: "success", duration: 3e3 }), g("success");
    } catch (n) {
      console.log("任务下发失败", n);
    } finally {
      d.value = false;
    }
  }
  return (n, e) => {
    const w = p("common-button"), o = E, I = p("common-table"), T = p("common-dialog");
    return c(), f(T, { title: "任务下发预览", customClass: "nesting-task-issue-preview", modelValue: r(i), "onUpdate:modelValue": e[0] || (e[0] = (l) => D(i) ? i.value = l : null), "close-on-click-modal": false, width: "1100px", showClose: false, "before-close": r(m) }, { titleRight: a(() => [t(w, { size: "default", type: "primary", loading: d.value, onClick: B }, { default: a(() => e[1] || (e[1] = [C(" 确认下发 ")])), _: 1, __: [1] }, 8, ["loading"]), t(w, { size: "default", onClick: r(m) }, { default: a(() => e[2] || (e[2] = [C(" 取消 ")])), _: 1, __: [2] }, 8, ["onClick"])]), default: a(() => [e[3] || (e[3] = u("div", { class: "tip" }, [u("span", null, "* 提示："), u("span", null, " 点击确认下发后，任务无法撤回，请再次确认！")], -1)), t(I, { data: s.list, "data-format": V.value, "max-height": r(N), style: { width: "100%" } }, { default: a(() => [t(o, { label: "序号", type: "index", align: "center", width: "60" }), t(o, { prop: "cutNumber", "show-overflow-tooltip": true, label: "切割指令号", "min-width": "120", align: "center" }), s.info.boolNestCutEnum ? (c(), f(o, { key: 0, prop: "spec", "show-overflow-tooltip": true, label: "原材料规格", "min-width": "120", align: "center" })) : k("", true), s.info.boolNestCutEnum ? (c(), f(o, { key: 1, prop: "num", "show-overflow-tooltip": true, label: "板材数量(件)", width: "120", align: "center" })) : k("", true), t(o, { prop: "cutName", "show-overflow-tooltip": true, label: "切割方式", width: "100", align: "center" }), t(o, { "show-overflow-tooltip": true, label: "生产组", "min-width": "160", align: "center" }, { default: a(({ row: l }) => {
      var v, h;
      return [u("span", null, _((v = l.workshop) == null ? void 0 : v.name) + ">" + _((h = l.productionLine) == null ? void 0 : h.name) + ">" + _(l.groupsName), 1)];
    }), _: 1 }), t(o, { prop: "askCompleteTime", "show-overflow-tooltip": true, label: "需求完成日期", width: "100", align: "center" })]), _: 1 }, 8, ["data", "data-format", "max-height"])]), _: 1, __: [3] }, 8, ["modelValue", "before-close"]);
  };
} }, O = P(z, [["__scopeId", "data-v-b12a141e"]]);
export {
  O as default
};
