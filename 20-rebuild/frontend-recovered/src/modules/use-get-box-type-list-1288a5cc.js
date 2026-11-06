import { ref as h } from "vue";
function y({ getApi: t, initHook: o }, l = false) {
  const f = h([]);
  async function u({ productionLineTypeEnum: c, areaIdList: e }) {
    if (l) {
      if (!c || !(e != null && e.length)) {
        f.value = [];
        return;
      }
    } else if (!(e != null && e.length)) {
      f.value = [];
      return;
    }
    try {
      const { content: n } = await t({ productionLineTypeEnum: c, areaIdList: e });
      f.value = n, typeof o == "function" && o();
    } catch (n) {
      console.log("获取分段排产类型汇总错误", n);
    }
  }
  return { boxTypeList: f, refreshBoxType: u };
}
export {
  y as u
};
